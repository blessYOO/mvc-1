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

    /** 사용자 등록 화면으로 이동 */
    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    /** 사용자 등록 */
    @PostMapping("/add")
    public String save(@ModelAttribute Member member) {
        memberRepository.save(member);
        return "basic/addForm";
    }

    /** [파라미터값 넘기기 연습 필요] 사용자 수정 화면으로 이동 */
    @GetMapping("/{memberId}/edit")
    public String editForm(@PathVariable("memberId") long memberId, Model model) {
        Member member = memberRepository.findById(memberId);
        model.addAttribute("member", member);
        return "basic/editForm";
    }

    /** [파라미터값 넘기기 연습 필요] 사용자 수정 */
    @PostMapping("/{memberId}/edit")
    public String edit(@PathVariable long memberId, @ModelAttribute Member member) {
        memberRepository.update(memberId, member);
        System.out.println("타긴 탐...");
        return "redirect:/basic/members/{memberId}";
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

