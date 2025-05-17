package sopt.Sopkathon.domain.activity.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.Sopkathon.domain.activity.entity.ActivityParticipation;
import sopt.Sopkathon.domain.activity.entity.ActivityPost;
import sopt.Sopkathon.domain.member.entity.Member;

@Repository
public interface ActivityParticipationRepository extends JpaRepository<ActivityParticipation, Long> {
    Optional<ActivityParticipation> findByMemberAndActivityPost(
            Member member,
            ActivityPost activityPost
    );

}
