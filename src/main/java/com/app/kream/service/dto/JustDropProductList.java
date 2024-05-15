package com.app.kream.service.dto;

import com.app.kream.domain.Product;

public record JustDropProductList(
        String thumbnailUrl,
        String brandTitle,
        String engTitle,
        String price,
        String transactionCount,
        Boolean isScrap,
        Boolean isFast
) {
    public static JustDropProductList of(
            final Product product,
            final Boolean isScrap
    ) {
        return new JustDropProductList(
                product.getThumbnailUrl(),
                product.getBrandTitle(),
                product.getEngTitle(),
                product.getPrice(),
                product.getTransactionCount(),
                isScrap,
                product.isFast()
        );
    }
}
