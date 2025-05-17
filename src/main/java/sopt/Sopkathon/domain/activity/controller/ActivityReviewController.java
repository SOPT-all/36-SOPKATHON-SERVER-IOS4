package sopt.Sopkathon.domain.activity.controller;


import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.Sopkathon.domain.activity.dto.response.ActivityReviewResponse;
import sopt.Sopkathon.domain.activity.service.ActivityReviewService;
import sopt.Sopkathon.global.common.dto.response.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/activity-posts")
public class ActivityReviewController {

    private final ActivityReviewService reviewService;

    @Operation(summary = "활동 리뷰 조회")
    @GetMapping("/{postId}/reviews")
    public ApiResponse<List<ActivityReviewResponse>> getReviews(
            @PathVariable Long postId
    ) {
        List<ActivityReviewResponse> result = reviewService.getReviewsByPostId(postId);
        return ApiResponse.success(200, "활동 리뷰 조회 성공", result);
    }
}
