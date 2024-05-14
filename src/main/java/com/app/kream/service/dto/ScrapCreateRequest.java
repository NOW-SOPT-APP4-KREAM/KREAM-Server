package com.app.kream.service.dto;


import lombok.Getter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Getter
public record ScrapCreateRequest(
        @RequestHeader Long memberId,
        @RequestBody Long productId
) {
}
