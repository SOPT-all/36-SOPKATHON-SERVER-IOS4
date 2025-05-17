package sopt.Sopkathon.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.Sopkathon.domain.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
