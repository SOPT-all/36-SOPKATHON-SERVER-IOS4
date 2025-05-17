package sopt.Sopkathon.domain.activity.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.Sopkathon.domain.activity.dto.response.ActivityPostDetailResponse;
import sopt.Sopkathon.domain.activity.dto.response.ActivityPostResponse;
import sopt.Sopkathon.domain.activity.entity.ActivityParticipation;
import sopt.Sopkathon.domain.activity.entity.ActivityPost;
import sopt.Sopkathon.domain.activity.entity.enums.ActivityTag;
import sopt.Sopkathon.domain.activity.exception.ActivityPostNotFoundException;
import sopt.Sopkathon.domain.activity.exception.DuplicateApplicationException;
import sopt.Sopkathon.domain.activity.repository.ActivityParticipationRepository;
import sopt.Sopkathon.domain.activity.repository.ActivityPostRepository;
import sopt.Sopkathon.domain.member.entity.Member;
import sopt.Sopkathon.domain.member.exception.MemberNotFoundException;
import sopt.Sopkathon.domain.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class ActivityPostService {

    private final ActivityPostRepository activityPostRepository;
    private final ActivityParticipationRepository activityParticipationRepository;
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<ActivityPostResponse> getActivityPosts(ActivityTag tag) {
        List<ActivityPost> posts = (tag != null) ? activityPostRepository.findAllByTag(tag) : activityPostRepository.findAll();

        return posts.stream()
                .map(ActivityPostResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public ActivityPostDetailResponse getDetail(Long postId) {
        ActivityPost post = activityPostRepository.findById(postId)
                .orElseThrow(() -> new ActivityPostNotFoundException(postId));
        return ActivityPostDetailResponse.from(post);
    }

    @Transactional
    public void apply(Long postId, Long memberId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));

        // 활동 조회 (없으면 404)
        ActivityPost post = activityPostRepository.findById(postId)
                .orElseThrow(() -> new ActivityPostNotFoundException(postId));

        // 중복 신청 체크 (있으면 409)
        activityParticipationRepository
                .findByMemberAndActivityPost(member, post)
                .ifPresent(p -> { throw new DuplicateApplicationException(); });

        // 신청 저장
        ActivityParticipation participation = ActivityParticipation.of(member, post);
        activityParticipationRepository.save(participation);
    }
}
