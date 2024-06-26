package com.app.kream.controller.product;

import com.app.kream.common.CommonResponse;
import com.app.kream.exception.SuccessMessage;
import com.app.kream.service.ProductService;
import com.app.kream.service.dto.DetailProductResponse;
import com.app.kream.service.dto.RecommendProductResponse;
import com.app.kream.service.dto.ReleaseProductResponse;
import com.app.kream.service.dto.SearchProductResponse;
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

    @Override
    @GetMapping("/recommend")
    public CommonResponse<RecommendProductResponse> getRecommendProduct(
            @RequestHeader final Long memberId
    ) {
        return CommonResponse.success(SuccessMessage.GET_RECOMMEND_PRODUCT_SUCCESS, productService.findRecommendProduct(memberId));
    }

    @Override
    @GetMapping
    public CommonResponse<SearchProductResponse> getFindProduct(
            @RequestParam(value = "findName") String findName
    ) {
        return CommonResponse.success(SuccessMessage.GET_FIND_PRODUCT_BY_NAME, productService.findSearchProduct(findName));
    }
}
