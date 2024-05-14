package com.app.kream.service.dto;

import com.app.kream.domain.StyleImage;

public record StyleResponse(
       String imageUrl,
       Boolean isVideo
) {
    public static StyleResponse of(
            final StyleImage styleImage
    ) {
        return new StyleResponse(
                styleImage.getImageUrl(),
                styleImage.isVideo()
        );
    }
}
