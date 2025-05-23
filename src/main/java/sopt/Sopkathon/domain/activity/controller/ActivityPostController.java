package sopt.Sopkathon.domain.activity.controller;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt.Sopkathon.domain.activity.dto.response.ActivityPostDetailResponse;
import sopt.Sopkathon.domain.activity.dto.response.ActivityPostResponse;
import sopt.Sopkathon.domain.activity.entity.enums.ActivityTag;
import sopt.Sopkathon.domain.activity.service.ActivityPostService;
import sopt.Sopkathon.global.common.dto.response.ApiResponse;

@RestController
@RequestMapping("/api/activity-posts")
@RequiredArgsConstructor
public class ActivityPostController {

    private final ActivityPostService activityPostService;

    @Operation(summary = "카테고리, 모집 마감 여부로 활동 글 조회")
    @GetMapping
    public ApiResponse<List<ActivityPostResponse>> getPosts(
            @RequestParam(required = false) ActivityTag tag,
            @RequestParam(required = false, defaultValue = "false") boolean excludeClosed
    ) { // 쿼리 파라미터 전달 x -> 전체 조회
        List<ActivityPostResponse> result = activityPostService.getActivityPosts(tag, excludeClosed);
        return ApiResponse.success(200, "활동 글 조회 성공", result);
    }

    @Operation(summary = "활동 상세 조회(활동 신청 페이지)")
    @GetMapping("/{postId}")
    public ApiResponse<ActivityPostDetailResponse> getDetail(@PathVariable Long postId) {
        ActivityPostDetailResponse dto = activityPostService.getDetail(postId);
        return ApiResponse.success(HttpStatus.OK.value(), "활동 상세 조회에 성공했습니다", dto
        );
    }

    @Operation(summary = "활동 신청하기(버튼 클릭시 활동 신청)")
    @PostMapping("/{postId}/apply")
    public ApiResponse<Void> applyActivity(@PathVariable Long postId, Long memberId) {
        activityPostService.apply(postId, memberId);
        return ApiResponse.success(HttpStatus.CREATED.value(), "활동 지원하기에 성공했습니다");
    }
}
