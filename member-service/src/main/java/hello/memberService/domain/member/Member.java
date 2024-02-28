package hello.memberService.domain.member;

import lombok.Data;

/**
 * 사용자 클래스
 * @author syyoo
 * */
@Data
public class Member {

    private Long id;
    private String memberName;
    private Integer age;
    private String phone;

    public Member() {
    }

    public Member(String memberName, Integer age, String phone) {
        this.memberName = memberName;
        this.age = age;
        this.phone = phone;
    }

}
