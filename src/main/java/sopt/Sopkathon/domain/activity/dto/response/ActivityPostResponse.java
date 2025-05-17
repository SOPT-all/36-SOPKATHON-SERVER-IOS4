package sopt.Sopkathon.domain.activity.dto.response;

import sopt.Sopkathon.domain.activity.entity.ActivityPost;

import java.time.LocalDateTime;

public record ActivityPostResponse(
        Long id,
        String title,
        String subject,
        String content,
        String participationFee,
        String region,
        boolean isFood,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String tag,
        long maxParticipation,
        int participantCount
) {
    public static ActivityPostResponse from(ActivityPost post) {
        int participantCount = post.getParticipations().size();

        return new ActivityPostResponse(
                post.getId(),
                post.getTitle(),
                post.getSubject(),
                post.getContent(),
                post.getParticipationFee(),
                post.getActivityRegion(),
                post.isFood(),
                post.getStartTime(),
                post.getEndTime(),
                post.getTag().name(),
                post.getMaxParticipation(),
                participantCount
        );
    }
}
