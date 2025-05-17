package sopt.Sopkathon.domain.activity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt.Sopkathon.domain.activity.dto.response.ActivityPostResponse;
import sopt.Sopkathon.domain.activity.entity.enums.ActivityTag;
import sopt.Sopkathon.domain.activity.service.ActivityPostService;
import sopt.Sopkathon.global.common.dto.response.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/activity-posts")
@RequiredArgsConstructor
public class ActivityPostController {

    private final ActivityPostService activityPostService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ActivityPostResponse>>> getPosts(
            @RequestParam(required = false) ActivityTag tag
    ) { // 쿼리 파라미터 전달 x -> 전체 조회
        List<ActivityPostResponse> result = activityPostService.getActivityPosts(tag);
        return ResponseEntity.ok(ApiResponse.success(200, "활동 글 조회 성공", result));
    }
}
