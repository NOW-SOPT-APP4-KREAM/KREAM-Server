package com.app.kream.service.dto;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public record ScrapCreateRequest(
        Long productId
) {
}
