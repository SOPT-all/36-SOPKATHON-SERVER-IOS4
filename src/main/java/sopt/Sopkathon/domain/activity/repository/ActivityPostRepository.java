package sopt.Sopkathon.domain.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.Sopkathon.domain.activity.entity.ActivityPost;
import sopt.Sopkathon.domain.activity.entity.enums.ActivityTag;

import java.util.List;

public interface ActivityPostRepository extends JpaRepository<ActivityPost, Long> {
    List<ActivityPost> findAllByTag(ActivityTag tag);
}