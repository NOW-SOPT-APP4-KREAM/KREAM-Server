package com.app.kream.service.dto;

import com.app.kream.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public record SearchFindProductResponse(
        String thumbnailUrl,
        String brandTitle,
        String engTitle,
        String title,
        String price,
        String transactionCount,
        String scrapCount,
        String styleCount,
        boolean isFast
) {
    public static SearchFindProductResponse of(
            final Product product
    ) {
        return new SearchFindProductResponse(
                product.getThumbnailUrl(),
                product.getBrandTitle(),
                product.getEngTitle(),
                product.getTitle(),
                product.getPrice(),
                product.getTransactionCount(),
                product.getScrapCount(),
                product.getStyleCount(),
                product.isFast()
        );
    }

    public static List<SearchFindProductResponse> convertSearchFindProductToResponses(
            List<Product> products
    ) {
        return products.stream()
                .map(SearchFindProductResponse::of)
                .collect(Collectors.toList());
    }
}
