package kr.swu.spring_mvc.controller;

import kr.swu.spring_mvc.domain.Board;
import kr.swu.spring_mvc.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("board") // localhost:8080/board
@AllArgsConstructor // final 변수에 객체 주입을 위해 생성자 생성
public class BoardController {
    
    // 컨트롤러는 원래 서비스를 호출해야 하지만 편의상 먼저 레포지토리 호출
    private final BoardRepository boardRepository;


    // 게시판 전체 글 목록을 조회할 수 있는 페이지
    // http://localhost:8080/board/list
    @GetMapping("list")
    public String goBoardList(Model model){
        // 레포지토리의 데이터를 컨트롤러 내부로 가져오기
        List<Board> boardList = boardRepository.getBoardList();
        System.out.println("컨트롤러가 가져온 전체 글 정보: " + boardList);
        // 가져온 데이터는 화면으로 보내주기
        model.addAttribute("boardList", boardList);
        return "board/board-list";
    }

    @GetMapping("write")
    public String goBoardWriteFrom(){
        return "board/board-form";
    }

    @PostMapping("board-write")
    public String saveBoard(Board board){
        // 파라미터로 선언한 Board 타입 변수 board 필드에 매칭이 된다.
        System.out.println("시간 지정 전: " + board);
        // board에 이어서 현재 시간을 저장한다.
        board.setCreatedAt(LocalDateTime.now());
        System.out.println("시간 지정 후: " + board);
        // 글에 대한 정보를 적재하고 있는 board 변수를 DB에 저장
        boardRepository.save(board);
        // 글 저장 후 전체 목록으로 돌아가기
        return "redirect:/board/list";
        
    }

    @GetMapping("detail/{boardNum}")
    public String goDetailPage(@PathVariable int boardNum, Model model){
        // 가져온 글 번호에 해당하는 게시글 하나의 정보 받아오기
        Board board = boardRepository.findBoardByBoardNum(boardNum);

        // 해당 게시글 정보를 addAttribute()로 화면단에 전송하기
        model.addAttribute("board", board);

        // 화면단을 출력할 .jsp 파일의 명칭을 지정한다.
        // 해당 .jsp 파일에 &{}를 이용해 글 하나의 정보를 출력하기
        return "/board/board-detail";
    }

    @PostMapping("delete") // ?boardNum=값 형태로 지워야 하니 파라미터는 boardNum
    public String deleteBoard(int boardNum){
        // 삭제 로직 수행
        boardRepository.deleteBoardByBoardNum(boardNum);
        // 리스트 페이지로 복귀
        return "redirect:/board/list";
    }
}
