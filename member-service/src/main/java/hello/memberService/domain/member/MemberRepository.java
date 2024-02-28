package hello.memberService.domain.member;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 멤버 리포지토리 클래스
 * @author syyoo
 * */
@Repository
public class MemberRepository {

    private static final Map<Long, Member> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    /** 사용자 저장 */
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    /** 상세조회 */
    public Member findById(Long id) {
        return store.get(id);
    }

    /** 전체조회 */
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    /** 수정저장 */
    public void update(Long memberId, Member updateParam) {
        Member findMember = findById(memberId);
        findMember.setMemberName(updateParam.getMemberName());
        findMember.setAge(updateParam.getAge());
        findMember.setPhone(updateParam.getPhone());
    }

    /** 맵 데이터 초기화 */
    public void clearStore() {
        store.clear();
    }

}
