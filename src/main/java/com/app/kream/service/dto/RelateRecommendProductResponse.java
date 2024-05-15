package com.app.kream.service.dto;

import com.app.kream.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public record RelateRecommendProductResponse(
        String thumbnailUrl,
        String engTitle,
        String price,
        Boolean isFast,
        String scrapCount

) {
    public static RelateRecommendProductResponse of(
            final Product product
    ) {
        return new RelateRecommendProductResponse(
                product.getThumbnailUrl(),
                product.getBrandTitle(),
                product.getEngTitle(),
                product.isFast(),
                product.getScrapCount()
        );
    }

    public static List<RelateRecommendProductResponse> convertForYouProductsToResponses(
            List<Product> products
    ) {
        return products.stream()
                .map(RelateRecommendProductResponse::of)
                .collect(Collectors.toList());
    }

}
