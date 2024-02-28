package hello.memberService.web.basic;

import hello.memberService.domain.member.Member;
import hello.memberService.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/members")
@RequiredArgsConstructor
public class BasicMemberController {

    private final MemberRepository memberRepository;

    /** 전체 사용자 조회 */
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "basic/members";
    }

    /** 사용자 상세 조회 */
    @GetMapping("/{memberId}")
    public String member(@PathVariable long memberId, Model model) {
        Member member = memberRepository.findById(memberId);
        model.addAttribute("member", member);
        return "basic/member";
    }

    /** 사용자 등록 */
    @GetMapping("/add")
    public String add() {
        return "basic/addForm";
    }



    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        memberRepository.save(new Member("유선영", 28, "01040923206"));
        memberRepository.save(new Member("유민서", 22, "01012345678"));
    }

}

