package kr.swu.spring_mvc.repository;

import kr.swu.spring_mvc.domain.Board;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // 빈 컨테이너에 레포지토리 클래스로 등록
public class BoardMemoryRepository implements BoardRepository{

    // 현재 연결된 DB가 없기 때문에 DB 대신 메모리에 로딩데이터를 저장
    // 현재 저장 데이터는 Map형식으로 저장할 예정
    private static final Map<Integer, Board> boardMap;

    // 글 번호에 사용할 일련번호
    private static int sequence; // 글 번호를 체크해주는 변수, 0으로 자동 초기화

    // 정적변수 boardMap을 초기화하는 블록
    static {
        boardMap = new HashMap<>();
        System.out.println("데이터 적재 전: " + boardMap);
        Board board1 = new Board(++sequence, "서울여대", LocalDateTime.now(), "3월 2일 개강");

        Board board2 = new Board(++sequence, "안녕", LocalDateTime.now(), "하세요");

        Board board3 = new Board(++sequence, "춘식이", LocalDateTime.now(), "춘식이다냥");

        boardMap.put(board1.getBoardNum(), board1);
        boardMap.put(board2.getBoardNum(), board2);
        boardMap.put(board3.getBoardNum(), board3);

        System.out.println("데이터 적재 후: " + boardMap);
    }
    @Override
    public List<Board> getBoardList() {
        // Map의 values()를 이용해서 게시물 전체 정보를 얻어온다.
        System.out.println(boardMap.values());

        // 빈 ArrayList 생성
        List<Board> resultList = new ArrayList<>();
        System.out.println("resultList 적재 전: " + resultList);

        // 반복문으로 resultList에 Board 객체 정리해서 넣기
        for(Board board : boardMap.values()){
            resultList.add(board);
        }
        System.out.println("resultList 적재 후: " + resultList);

        return resultList;
    }

    // 글 번호를 받으면 해당 글의 자료를 하나 가져와서 리턴
    @Override
    public Board findBoardByBoardNum(int boardNum) {
        return boardMap.get(boardNum);
    }

    @Override
    public boolean deleteBoardByBoardNum(int boardNum) {
        // 만약 존재하지 않는 키값을 집어넣는다면
        if(!boardMap.containsKey(boardNum)) return false;
        boardMap.remove(boardNum);
        return true;
    }

    @Override
    public boolean save(Board board) {
        // 사용된 적 없는 글 번호를 활용해 신규 저장
        board.setBoardNum(++sequence);
        boardMap.put(board.getBoardNum(), board);
        return true;
    }
}
