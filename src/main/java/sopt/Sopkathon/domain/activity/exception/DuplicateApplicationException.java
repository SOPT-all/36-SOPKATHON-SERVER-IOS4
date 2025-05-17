package sopt.Sopkathon.domain.activity.exception;

import org.springframework.http.HttpStatus;
import sopt.Sopkathon.global.common.exception.BaseException;

public class DuplicateApplicationException extends BaseException {
    public DuplicateApplicationException() {
        super(HttpStatus.CONFLICT, "이미 신청된 활동입니다.");
    }
}
