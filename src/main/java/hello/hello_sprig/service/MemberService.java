package hello.hello_sprig.service;

import hello.hello_sprig.domain.Member;
import hello.hello_sprig.repository.MemberRepository;
import hello.hello_sprig.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member);
        // memberRepository.findbyName(member.getName()) 가
        // optional 반환이기 때문에 바로 .ifPresent 사용 가능
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findbyName(member.getName())
            .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }
    // ctrl + alt + m

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id) {
        return memberRepository.findbyId(id);
    }
}
