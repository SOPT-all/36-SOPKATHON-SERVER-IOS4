package sopt.Sopkathon.domain.activity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.Sopkathon.domain.activity.dto.response.ActivityPostResponse;
import sopt.Sopkathon.domain.activity.entity.ActivityPost;
import sopt.Sopkathon.domain.activity.entity.enums.ActivityTag;
import sopt.Sopkathon.domain.activity.repository.ActivityPostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityPostService {

    private final ActivityPostRepository activityPostRepository;

    @Transactional(readOnly = true)
    public List<ActivityPostResponse> getActivityPosts(ActivityTag tag) {
        List<ActivityPost> posts = (tag != null) ? activityPostRepository.findAllByTag(tag) : activityPostRepository.findAll();

        return posts.stream()
                .map(ActivityPostResponse::from)
                .toList();
    }
}
