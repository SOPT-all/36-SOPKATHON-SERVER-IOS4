package sopt.Sopkathon.domain.activity.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.Sopkathon.domain.activity.dto.response.ActivityReviewResponse;
import sopt.Sopkathon.domain.activity.service.ActivityReviewService;
import sopt.Sopkathon.global.common.dto.response.ApiResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/activity-posts")
public class ActivityReviewController {

    private final ActivityReviewService reviewService;

    @GetMapping("/{postId}/reviews")
    public ResponseEntity<ApiResponse<List<ActivityReviewResponse>>> getReviews(
            @PathVariable Long postId
    ) {
        List<ActivityReviewResponse> result = reviewService.getReviewsByPostId(postId);
        return ResponseEntity.ok(ApiResponse.success(200, "활동 리뷰 조회 성공", result));
    }
}
