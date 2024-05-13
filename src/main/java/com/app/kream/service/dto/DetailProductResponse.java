package com.app.kream.service.dto;

import com.app.kream.domain.Product;

import java.util.List;

public record DetailProductResponse(
        String thumbnailUrl,
        String price,
        String engTitle,
        String title,
        String recentPrice,
        String variablePrice,
        String variablePercent,
        String releasePrice,
        String modelNumber,
        String releaseDate,
        String styleCount,
        List<StyleResponse> styles
) {
    public static DetailProductResponse of(
            final Product product
    ) {
        return new DetailProductResponse(
                product.
        );
    }
}
