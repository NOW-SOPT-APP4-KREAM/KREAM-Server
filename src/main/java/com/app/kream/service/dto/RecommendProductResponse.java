package com.app.kream.service.dto;

import java.util.List;

public record RecommendProductResponse(
        List<ForYouProductResponse> forYouList,
        List<JustDropProductResponse> justDropList
) {
    public static RecommendProductResponse of(
            List<ForYouProductResponse> forYouList,
            List<JustDropProductResponse> justDropList
    ) {
        return new RecommendProductResponse(
                forYouList,
                justDropList
        );
    }
}
