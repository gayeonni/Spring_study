package kr.swu.spring_mvc.chap01.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // lombok 설치 시 사용 가능, getter, setter를 자동으로 생성
@Setter
@ToString // toString을 레퍼런스가 아닌 내부 멤버값으로 바꿔준다.
public class Human { // 사람이 가져야 할 정보
    private String name;
    private int age;
    private String address;
}
