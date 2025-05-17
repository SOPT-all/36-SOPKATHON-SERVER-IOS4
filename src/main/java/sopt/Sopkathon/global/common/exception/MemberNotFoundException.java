package sopt.Sopkathon.global.common.exception;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends BaseException {
    public MemberNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, ErrorMessage.MEMBER_NOT_FOUND.getMessage() + " id=" + id);
    }
}
