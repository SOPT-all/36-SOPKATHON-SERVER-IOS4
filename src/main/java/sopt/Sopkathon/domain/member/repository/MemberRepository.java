package sopt.Sopkathon.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.Sopkathon.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
