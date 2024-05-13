package com.app.kream.controller.product;

import com.app.kream.common.CommonResponse;
import com.app.kream.exception.SuccessMessage;
import com.app.kream.service.ProductService;
import com.app.kream.service.dto.DetailProductResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController implements ProductControllerSwagger {

    private final ProductService productService;

    @Override
    @GetMapping("/{productId}")
    public CommonResponse<DetailProductResponse> getDetailProduct(
            @RequestHeader final Long userId,
            @PathVariable final Long productId
    ) {
        return CommonResponse.success(SuccessMessage.GET_DETAIL_PRODUCT_SUCCESS, productService.findDetailProductById(userId, productId));
    }
}
