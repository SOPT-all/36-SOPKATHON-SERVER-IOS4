package sopt.Sopkathon.domain.activity.dto.response;


import java.time.LocalDateTime;
import sopt.Sopkathon.domain.activity.entity.ActivityPost;

public record ActivitySummaryResponse(
        Long activityId,
        String title,
        String region,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Long userId,    // 유저 이름 추가
        String telephone

) {
    public static ActivitySummaryResponse from(ActivityPost post) {
        return new ActivitySummaryResponse(
                post.getId(),
                post.getTitle(),
                post.getActivityRegion(),
                post.getStartTime(),
                post.getEndTime(),
                post.getWriter().getId(),
                post.getWriter().getTelephone()
        );
    }
}
