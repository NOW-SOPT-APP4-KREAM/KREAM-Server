package com.app.kream.controller.product;

import com.app.kream.common.CommonResponse;
import com.app.kream.service.dto.DetailProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(name = "상품", description = "상품 관련 API 입니다.")
public interface ProductControllerSwagger {
    @Operation(summary = "세부 상품 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "세부 상품 조회에 성공했습니다."),
            @ApiResponse(responseCode = "404",
                    description = "1. ID에 해당하는 사용자가 존재하지 않습니다.\n" +
                            "2. ID에 해당하는 상품이 존재하지 않습니다.",
                    content = @Content(schema = @Schema(implementation = CommonResponse.class))),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류입니다.", content = @Content(schema = @Schema(implementation = CommonResponse.class)))
    })
    CommonResponse<DetailProductResponse> getDetailProduct(
            @RequestHeader final Long memberId,
            @PathVariable final Long productId
    );
}
