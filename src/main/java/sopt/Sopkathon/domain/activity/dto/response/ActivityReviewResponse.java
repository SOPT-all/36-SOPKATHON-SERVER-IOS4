package sopt.Sopkathon.domain.activity.dto.response;

import java.time.LocalDateTime;
import sopt.Sopkathon.domain.activity.entity.ActivityReview;

public record ActivityReviewResponse(
        Long id,
        String content,
        int star,
        Long memberId,
        LocalDateTime createDate,
        String activityImageUrl
) {
    public static ActivityReviewResponse from(ActivityReview review) {
        return new ActivityReviewResponse(
                review.getId(),
                review.getContent(),
                review.getStar(),
                review.getMember().getId(),
                review.getCreateDate(),
                review.getActivityPost().getImageUrl()
        );
    }
}
