package com.app.kream.service.dto;

import com.app.kream.domain.Product;

public record JustDropProductResponse(
        String thumbnailUrl,
        String brandTitle,
        String engTitle,
        String price,
        String transactionCount,
        Boolean isScrap,
        Boolean isFast,
        Boolean isFreeDeliver,
        Boolean isSave,
        Boolean isCoupon
) {
    public static JustDropProductResponse of(
            final Product product,
            final Boolean isScrap
    ) {
        return new JustDropProductResponse(
                product.getThumbnailUrl(),
                product.getBrandTitle(),
                product.getEngTitle(),
                product.getPrice(),
                product.getTransactionCount(),
                isScrap,
                product.isFast(),
                product.isFreeDeliver(),
                product.isSave(),
                product.isCoupon()
        );
    }
}
