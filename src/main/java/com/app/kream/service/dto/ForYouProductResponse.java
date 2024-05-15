package com.app.kream.service.dto;

import com.app.kream.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<ForYouProductResponse> convertForYouProductsToResponses(
            List<Product> products
    ) {
        return products.stream()
                .map(ForYouProductResponse::of)
                .collect(Collectors.toList());
    }
}
