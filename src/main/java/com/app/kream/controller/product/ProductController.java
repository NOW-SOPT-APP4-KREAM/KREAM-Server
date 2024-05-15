package com.app.kream.controller.product;

import com.app.kream.common.CommonResponse;
import com.app.kream.exception.SuccessMessage;
import com.app.kream.service.ProductService;
import com.app.kream.service.dto.DetailProductResponse;
import com.app.kream.service.dto.ReleaseProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController implements ProductControllerSwagger {

    private final ProductService productService;

    @Override
    @GetMapping("/{productId}")
    public CommonResponse<DetailProductResponse> getDetailProduct(
            @RequestHeader final Long memberId,
            @PathVariable final Long productId
    ) {
        return CommonResponse.success(SuccessMessage.GET_DETAIL_PRODUCT_SUCCESS, productService.findDetailProductById(memberId, productId));
    }

    @Override
    @GetMapping("/release")
    public CommonResponse<ReleaseProductResponse> getReleaseProduct(
            @RequestHeader final Long memberId
    ) {
        return CommonResponse.success(SuccessMessage.GET_RELEASE_PRODUCT_SUCCESS, productService.findReleaseProduct(memberId));
    }
}
