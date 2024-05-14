package com.app.kream.service.dto;

import com.app.kream.domain.Product;
import com.app.kream.domain.StyleImage;

import java.util.List;
import java.util.stream.Collectors;

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
            final Product product,
            final List<StyleImage> styles
    ) {
        return new DetailProductResponse(
                product.getThumbnailUrl(),
                product.getPrice(),
                product.getEngTitle(),
                product.getTitle(),
                product.getRecentPrice(),
                product.getVariablePrice(),
                product.getVariablePercent(),
                product.getReleasePrice(),
                product.getModelNumber(),
                product.getReleaseDate(),
                product.getStyleCount(),
                convertStylesToResponses(styles)
        );
    }

    private static List<StyleResponse> convertStylesToResponses(List<StyleImage> styleImages) {
        return styleImages.stream()
                .map(StyleResponse::of)
                .collect(Collectors.toList());
    }
}
