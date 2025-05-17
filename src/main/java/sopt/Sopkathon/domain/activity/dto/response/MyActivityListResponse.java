package sopt.Sopkathon.domain.activity.dto.response;

import java.util.List;

public record MyActivityListResponse(
        List<ActivitySummaryResponse> applicationCompleteActivities,
        List<ActivitySummaryResponse> participationCompleteActivities
) {
}