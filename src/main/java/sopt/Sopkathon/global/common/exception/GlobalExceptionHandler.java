package sopt.Sopkathon.global.common.exception;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import sopt.Sopkathon.global.common.dto.response.ApiResponse;
import sopt.Sopkathon.global.common.exception.response.ValidErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseStatus
    public ApiResponse<Void> handleBase(BaseException e) {
        return ApiResponse.error(
                e.getStatus().value(),
                e.getMessage()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<List<ValidErrorResponse>> handleValidation(MethodArgumentNotValidException e) {
        List<ValidErrorResponse> errors = e.getBindingResult()
                .getFieldErrors().stream()
                .map(fe -> ValidErrorResponse.of(
                        fe.getField(),
                        fe.getDefaultMessage(),
                        fe.getRejectedValue()
                ))
                .toList();

        return ApiResponse.error(
                HttpStatus.BAD_REQUEST.value(),
                ErrorMessage.VALIDATION_ERROR.getMessage(),
                errors
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleIllegalArgument(IllegalArgumentException e) {
        return ApiResponse.error(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage()
        );
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Void> handleNotFound(NoResourceFoundException e) {
        return ApiResponse.error(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()
        );
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ApiResponse<Void> handleMethodNotAllowed(HttpRequestMethodNotSupportedException e) {
        return ApiResponse.error(
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                e.getMessage()
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getMostSpecificCause();
        if (cause instanceof BaseException baseEx) {
            return ApiResponse.error(
                    baseEx.getStatus().value(),
                    baseEx.getMessage()
            );
        }

        return ApiResponse.error(
                HttpStatus.BAD_REQUEST.value(),
                ErrorMessage.JSON_PARSE_ERROR.getMessage()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Void> handleAll(Exception e) {
        return ApiResponse.error(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage()
        );
    }
}
