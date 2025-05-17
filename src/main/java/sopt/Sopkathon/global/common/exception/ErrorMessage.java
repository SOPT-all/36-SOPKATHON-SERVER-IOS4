package sopt.Sopkathon.global.common.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    JSON_PARSE_ERROR("잘못된 JSON 형식의 요청입니다."),
    VALIDATION_ERROR("입력값 검증에 실패했습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
