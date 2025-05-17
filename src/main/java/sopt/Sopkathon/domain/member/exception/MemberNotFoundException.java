package sopt.Sopkathon.domain.member.exception;

import org.springframework.http.HttpStatus;
import sopt.Sopkathon.global.common.exception.BaseException;

public class MemberNotFoundException extends BaseException {
  public MemberNotFoundException(Long memberId) {
    super(HttpStatus.NOT_FOUND, "회원이 없습니다. id=" + memberId);
  }
}
