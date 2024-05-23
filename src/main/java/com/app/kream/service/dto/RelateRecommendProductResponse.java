package com.app.kream.service.dto;

import com.app.kream.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public record RelateRecommendProductResponse(
        String thumbnailUrl,
        String engTitle,
        String price,
        boolean isFast,
        String scrapCount,
        String styleCount,
        boolean isFreeDevliver,
        boolean isSave,
        boolean isCoupon

) {
    public static RelateRecommendProductResponse of(
            final Product product
    ) {
        return new RelateRecommendProductResponse(
                product.getThumbnailUrl(),
                product.getEngTitle(),
                product.getPrice(),
                product.isFast(),
                product.getScrapCount(),
                product.getStyleCount(),
                product.isFreeDeliver(),
                product.isSave(),
                product.isCoupon()
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
