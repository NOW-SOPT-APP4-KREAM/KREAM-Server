package com.app.kream.service.dto;

import java.util.List;

public record ReleaseProductResponse(
        List<ReleaseProductInfoResponse> releaseProducts
) {
    public static ReleaseProductResponse of(List<ReleaseProductInfoResponse> products) {
        return new ReleaseProductResponse(products);
    }
}
