package com.app.kream.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessMessage {
    /**
     * 200 OK SUCCESS
     */
    PROCESS_SUCCESS(HttpStatus.OK.value(), "OK"),
    GET_DETAIL_PRODUCT_SUCCESS(HttpStatus.OK.value(), "세부 상품 조회에 성공했습니다."),
    GET_RELEASE_PRODUCT_SUCCESS(HttpStatus.OK.value(), "발매 상품 정보 조회에 성공했습니다."),

    /**
     * 201 CREATED SUCCESS
     */


    ;

    private final int status;
    private final String message;
}
