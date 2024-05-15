package com.app.kream.service.dto;

import java.util.List;

public record SearchProductResponse(
        List<SearchFindProductResponse> searchFindProductResponses,
        List<RelateRecommendProductResponse> relateRecommendProductResponses
) {
    public static SearchProductResponse of(
            List<SearchFindProductResponse> searchFindProductResponses,
            List<RelateRecommendProductResponse> relateRecommendProductResponses
    ) {
        return new SearchProductResponse(
                searchFindProductResponses,
                relateRecommendProductResponses
        );
    }
}
