package com.app.kream.service.dto;

import com.app.kream.domain.Product;

import java.util.List;

public record ReleaseProductResponse(
        List<ReleaseProductInfoResponse> releaseProducts
) {
    public static ReleaseProductResponse of(List<ReleaseProductInfoResponse> products) {
        return new ReleaseProductResponse(products);
    }
}
