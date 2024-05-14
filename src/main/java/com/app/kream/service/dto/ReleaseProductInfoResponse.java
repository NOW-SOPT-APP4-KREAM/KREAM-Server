package com.app.kream.service.dto;

import com.app.kream.domain.Product;
import com.app.kream.domain.ProductStatus;
import com.app.kream.domain.Scrap;

import java.util.List;

public record ReleaseProductInfoResponse(
        String thumbnailUrl,
        String brandTitle,
        String title,
        Boolean isScrap,
        Boolean isUpdate,
        Boolean isNew
) {
    public static ReleaseProductInfoResponse of(
            final Product product,
            final List<Scrap> scraps
    ) {
        return new ReleaseProductInfoResponse(
                product.getThumbnailUrl(),
                product.getBrandTitle(),
                product.getTitle(),
                checkIsScrap(product.getId(), scraps),
                checkIsUpdate(product.getStatus()),
                checkIsNew(product.getStatus())
        );
    }
    private static Boolean checkIsScrap(Long productId, List<Scrap> scraps) {
        return scraps.stream()
                .anyMatch(scrap -> scrap.getProductId().equals(productId));
    }

    private static Boolean checkIsUpdate(ProductStatus status) {
        return status == ProductStatus.UPDATE;
    }

    private static Boolean checkIsNew(ProductStatus status) {
        return status == ProductStatus.NEW;
    }
}
