package kr.swu.spring_mvc.repository;

import kr.swu.spring_mvc.domain.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


// 테스트 코드를 작성하는 클래스 상단에는 @SpringBootTest 애터네이션을 붙인다.
@SpringBootTest
public class BoardMemoryRepositoryTest {

    // 테스트할 클래스를 아래에 선언하고 의존성 주입을 위해 @Autowired 애터네이션을 붙인다.
    @Autowired
    private BoardRepository boardRepository;

    // 해당 클래스의 특정 기능을 호출하기 위해
    // @Test 애너테이션을 위에 붙인 메서드를 작성한다.
    // 마치 이 메서드가 메인메서드처럼 동작해서 검증을 돕는다.
    @Test
    @DisplayName("전체 글을 가져와서 첫 번째 글의 작성자를 조회하면 서울여대일 것이다.")
    public void getBoardListTest(){
        // given: when절에서 활용할 테스트 코드에 대한 사전 준비
        // getBoardList는 제공해야하는 파라미터나 사전 조건이 없다.

        // when: 실제로 기능을 돌려서 수행시키는 단계
        List<Board> boardList = boardRepository.getBoardList();

        // then: when절에서 돌린 기능이 의도대로 됐는지 검증하는 부분
        // 보통 단언문인 assertEquals 등으로 검증한다.
        // import static methods 클릭 후 jupiter...를 입력
        // expect와 actual 2개의 데이터를 입력한다.

        // when절에서 얻어온 boardList의 첫 자료의 writer는 "서울여대"일 것이라고 단언한다.
        assertEquals("서울여대", boardList.get(0).getWriter());
        assertEquals("서울여자대학원", boardList.get(1).getWriter());

    }

    @Test
    public void findBoardByBoardNumTest(){
        // given: 사전 준비
        // 대부분의 코드에서 매직넘버를 직접 쓰지 않는 것이 좋다.
        // findBoardByBoardNum() 호출 시 int 자료 하나를 넘겨야 하므로
        // given절에서 해당 자료를 미리 선언한다.
        final int BOARD_NUM = 2; // 2번 글에 대한 조회를 할 예정

        // when: 실제 기능 호출
        Board board = boardRepository.findBoardByBoardNum(BOARD_NUM);

        // then: when절 결과에 대한 단언
        assertEquals("하세요", board.getContent());
        assertEquals("안녕", board.getWriter());
    }

    @Test
    public void deleteBoardByBoardNumTest(){
        // given: 삭제할 글을 아래에 변수로 저장
        final int BOARD_NUM = 2;
        
        // when: 삭제 후에 전체 데이터의 개수를 .size()로 조회해 변수에 저장
        // 그 다음 이미 삭제된 글 번호로 또 삭제를 수행하고 결과를 변수에 저장.
        boardRepository.deleteBoardByBoardNum(BOARD_NUM);
        int boardListSize = boardRepository.getBoardList().size();
        boolean deleteBool = boardRepository.deleteBoardByBoardNum(BOARD_NUM);
        
        // then: 단언문에서 데이터 개수를 단언, boolean 결과도 단언
        assertEquals(2,boardListSize);
        assertEquals(false, deleteBool);
    }

    // save 로직
    @Test
    @DisplayName("4번 글을 저장한 다음 4번 글을 얻어오면 입력한 정보가 조회됨")
    public void saveTest(){
        // given
        // 글 번호를 제외한 나머지를 미리 변수에 저장
        final String WRITER = "인프라개발자";
        final LocalDateTime NOW = LocalDateTime.now();
        final String CONTENT = "퍼블릭클라우드";
        final int BOARD_NUM = 4;
        // boardNum은 save 도중 ++sequence에 의해 보정되므로 0으로 넣어도 무방
        Board board = new Board(BOARD_NUM, WRITER, NOW, CONTENT);

        // when: 구현한 .save()가 실제로 동작하는 지 검증
        // 저장로직을 돌린 후 실제로 저장되었는지 확인
        boardRepository.save(board);
        Board result = boardRepository.findBoardByBoardNum(BOARD_NUM);
        int boardListSize = boardRepository.getBoardList().size();

        // then
        // 개수는 4개, 4번 글을 가져왔을 때 위에 given에 정의한 데이터가 그대로 나와야 한다.
        assertEquals(4, boardListSize);
        assertEquals(WRITER, board.getWriter());
        assertEquals(CONTENT, board.getContent());
    }
}
