package hello.hello_sprig.repository;

import hello.hello_sprig.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberReository {
    Member save(Member member);
    Optional<Member> findbyId(Long id);
    Optional<Member> findbyName(String name);
    List<Member> findAll();

}
