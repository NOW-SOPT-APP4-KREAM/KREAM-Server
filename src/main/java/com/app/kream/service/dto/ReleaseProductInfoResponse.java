package com.app.kream.service.dto;

import com.app.kream.domain.Product;
import com.app.kream.domain.ProductStatus;

public record ReleaseProductInfoResponse(
        String thumbnailUrl,
        String brandTitle,
        String engTitle,
        Boolean isScrap,
        Boolean isUpdate,
        Boolean isNew
) {
    public static ReleaseProductInfoResponse of(
            final Product product,
            final Boolean isScrap
    ) {
        return new ReleaseProductInfoResponse(
                product.getThumbnailUrl(),
                product.getBrandTitle(),
                product.getEngTitle(),
                isScrap,
                checkIsUpdate(product.getStatus()),
                checkIsNew(product.getStatus())
        );
    }

    private static Boolean checkIsUpdate(ProductStatus status) {
        return status == ProductStatus.UPDATE;
    }

    private static Boolean checkIsNew(ProductStatus status) {
        return status == ProductStatus.NEW;
    }
}
