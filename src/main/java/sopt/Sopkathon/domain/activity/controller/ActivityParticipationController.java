package sopt.Sopkathon.domain.activity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.Sopkathon.domain.activity.dto.response.MyActivityListResponse;
import sopt.Sopkathon.domain.activity.service.ActivityParticipationService;
import sopt.Sopkathon.global.common.dto.response.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class ActivityParticipationController {

    private final ActivityParticipationService participationService;

    @GetMapping("/{memberId}/activities")
    public ResponseEntity<ApiResponse<MyActivityListResponse>> getMyActivities(
            @PathVariable Long memberId
    ) {
        MyActivityListResponse response = participationService.getMyActivities(memberId);
        return ResponseEntity.ok(ApiResponse.success(200, "신청/참여 활동 조회 성공", response));
    }
}
