package sopt.Sopkathon.domain.activity.dto.response;

import java.time.LocalDateTime;
import sopt.Sopkathon.domain.activity.entity.ActivityPost;
import sopt.Sopkathon.domain.activity.entity.enums.ActivityTag;

public record ActivityPostDetailResponse(
        String title,
        String content,
        String subject,
        String participationFee,
        LocalDateTime startTime,
        LocalDateTime endTime,
        ActivityTag tag,
        String imageUrl
) {
    public static ActivityPostDetailResponse from(ActivityPost post) {
        return new ActivityPostDetailResponse(
                post.getTitle(),
                post.getContent(),
                post.getSubject(),
                post.getParticipationFee(),
                post.getStartTime(),
                post.getEndTime(),
                post.getTag(),
                post.getImageUrl()
        );
    }
}
