package sopt.Sopkathon.domain.activity.exception;

import org.springframework.http.HttpStatus;
import sopt.Sopkathon.global.common.exception.BaseException;

public class ActivityPostNotFoundException extends BaseException {
    public ActivityPostNotFoundException(Long postId) {
        super(HttpStatus.NOT_FOUND, "활동을 찾을 수 없습니다. id=" + postId);
    }
}
