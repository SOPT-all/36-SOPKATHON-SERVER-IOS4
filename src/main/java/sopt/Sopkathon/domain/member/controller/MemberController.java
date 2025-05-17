package sopt.Sopkathon.domain.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.Sopkathon.domain.activity.dto.response.MyActivityListResponse;
import sopt.Sopkathon.domain.activity.service.ActivityParticipationService;
import sopt.Sopkathon.domain.member.dto.response.MemberResponse;
import sopt.Sopkathon.domain.member.service.MemberService;
import sopt.Sopkathon.global.common.dto.response.ApiResponse;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ActivityParticipationService participationService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MemberResponse>> getMember(@PathVariable Long id) {
        MemberResponse member = memberService.getById(id);
        return ResponseEntity.ok(ApiResponse.success(200, "회원 조회 성공", member));
    }

    @GetMapping("/{memberId}/activities")
    public ApiResponse<MyActivityListResponse> getMyActivities(
            @PathVariable Long memberId
    ) {
        MyActivityListResponse response = participationService.getMyActivities(memberId);
        return ApiResponse.success(200, "신청/참여 활동 조회 성공", response);
    }
}