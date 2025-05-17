package sopt.Sopkathon.domain.activity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.Sopkathon.domain.activity.dto.response.ActivitySummaryResponse;
import sopt.Sopkathon.domain.activity.dto.response.MyActivityListResponse;
import sopt.Sopkathon.domain.activity.entity.ActivityParticipation;
import sopt.Sopkathon.domain.activity.entity.enums.ParticipationStatus;
import sopt.Sopkathon.domain.activity.repository.ActivityParticipationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityParticipationService {

    private final ActivityParticipationRepository participationRepository;

    @Transactional(readOnly = true)
    public MyActivityListResponse getMyActivities(Long memberId) {
        List<ActivityParticipation> application = participationRepository.findAllByMemberIdAndStatus(memberId, ParticipationStatus.APPLICATION_COMPLETE);

        List<ActivityParticipation> participation = participationRepository.findAllByMemberIdAndStatus(memberId, ParticipationStatus.PARTICIPATION_COMPLETE);

        List<ActivitySummaryResponse> applyingList = application.stream()
                .map(p -> ActivitySummaryResponse.from(p.getActivityPost()))
                .toList();

        List<ActivitySummaryResponse> participatedList = participation.stream()
                .map(p -> ActivitySummaryResponse.from(p.getActivityPost()))
                .toList();

        return new MyActivityListResponse(applyingList, participatedList);
    }
}