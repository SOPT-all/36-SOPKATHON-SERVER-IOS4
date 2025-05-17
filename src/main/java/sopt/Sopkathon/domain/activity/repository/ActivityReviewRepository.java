package sopt.Sopkathon.domain.activity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.Sopkathon.domain.activity.entity.ActivityReview;

import java.util.List;

@Repository
public interface ActivityReviewRepository extends JpaRepository<ActivityReview, Long> {
    List<ActivityReview> findAllByActivityPostId(Long postId);
}