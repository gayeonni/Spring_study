package kr.swu.spring_mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Board {

    // 한 줄 게시판에 필요한 정보들(글 번호, 작성자, 날짜, 본문)
    private int boardNum;
    private String writer;
    private LocalDateTime createdAt;
    private String content;

}
