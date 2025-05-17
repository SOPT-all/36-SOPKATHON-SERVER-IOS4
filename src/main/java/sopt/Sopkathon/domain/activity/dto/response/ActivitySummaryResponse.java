package sopt.Sopkathon.domain.activity.dto.response;


import sopt.Sopkathon.domain.activity.entity.ActivityPost;

import java.time.LocalDateTime;

public record ActivitySummaryResponse(
        Long activityId,
        String title,
        String region,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
    public static ActivitySummaryResponse from(ActivityPost post) {
        return new ActivitySummaryResponse(
                post.getId(),
                post.getTitle(),
                post.getActivityRegion(),
                post.getStartTime(),
                post.getEndTime()
        );
    }
}
