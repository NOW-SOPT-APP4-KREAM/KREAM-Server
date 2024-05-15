package com.app.kream.service.dto;

import com.app.kream.domain.Product;

public record ForYouProductResponse(
        String thumbnailUrl,
        String brandTitle,
        String engTitle,
        String price,
        String transactionCount
) {
    public static ForYouProductResponse of(
            final Product product
    ) {
        return new ForYouProductResponse(
                product.getThumbnailUrl(),
                product.getBrandTitle(),
                product.getEngTitle(),
                product.getPrice(),
                product.getTransactionCount()
        );
    }
}
