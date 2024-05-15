package com.app.kream.service.dto;

import java.util.List;

public record RecommendProductResponse(
        List<ForYouProductResponse> forYouList,
        List<JustDropProductList> justDropList
) {
    public static RecommendProductResponse of(
            List<ForYouProductResponse> forYouList,
            List<JustDropProductList> justDropList
    ) {
        return new RecommendProductResponse(
                forYouList,
                justDropList
        );
    }
}
