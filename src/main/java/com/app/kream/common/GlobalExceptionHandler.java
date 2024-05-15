package com.app.kream.common;

import com.app.kream.exception.ErrorMessage;
import com.app.kream.exception.model.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 500 INTERNAL SERVER ERROR
     */
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<CommonResponse> handleInternalServerError(final BusinessException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(CommonResponse.error(ErrorMessage.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<CommonResponse> handleInternalServerError(final Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(CommonResponse.error(ErrorMessage.INTERNAL_SERVER_ERROR));
    }
}
