package com.app.kream.service.dto;

import java.util.List;

public record RecommendProductResponse(
        List<ForYouProductResponse> forYouList,
        List<JustDropProductList> justDropList
) {
}
