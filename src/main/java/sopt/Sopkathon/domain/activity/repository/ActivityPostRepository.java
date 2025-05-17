package sopt.Sopkathon.domain.activity.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.Sopkathon.domain.activity.entity.ActivityPost;
import sopt.Sopkathon.domain.activity.entity.enums.ActivityTag;

@Repository
public interface ActivityPostRepository extends JpaRepository<ActivityPost, Long> {
    List<ActivityPost> findAllByTag(ActivityTag tag);
}