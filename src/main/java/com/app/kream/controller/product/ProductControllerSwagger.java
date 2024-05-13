package com.app.kream.controller.product;

import com.app.kream.common.CommonResponse;
import com.app.kream.service.dto.DetailProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(name = "상품", description = "상품 관련 API 입니다.")
public interface ProductControllerSwagger {
    @Operation(summary = "세부 상품 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "세부 상품 조회에 성공했습니다.")
    })
    CommonResponse<DetailProductResponse> getDetailProduct(
            @RequestHeader final Long memberId,
            @PathVariable final Long productId
    );
}
