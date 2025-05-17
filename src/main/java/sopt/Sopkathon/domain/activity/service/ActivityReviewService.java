package sopt.Sopkathon.domain.activity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.Sopkathon.domain.activity.dto.response.ActivityReviewResponse;
import sopt.Sopkathon.domain.activity.repository.ActivityReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityReviewService {

    private final ActivityReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public List<ActivityReviewResponse> getReviewsByPostId(Long postId) {
        return reviewRepository.findAllByActivityPostId(postId).stream()
                .map(ActivityReviewResponse::from)
                .toList();
    }
}
