package kr.swu.spring_mvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RequestController {

    // http://localhost:8080/test 접속 시 메서드 실행
    @RequestMapping("/test")
    public String getTest() {
        // RestController가 아닌 Controller의 String return 메서드는
        // WEB-INF/views/리턴하는파일명.jsp 를 호출한다.
        return "test";
    }

    // test2.jsp와 연결된 컨트롤러
    // http://localhost:8080/test2 접속 시 메서드가 실행된다.
    @RequestMapping("/test2")
    public String testSpring() {
        return "test2";
    }
}
