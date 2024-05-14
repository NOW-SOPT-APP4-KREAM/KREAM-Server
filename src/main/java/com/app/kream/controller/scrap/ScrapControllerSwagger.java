package com.app.kream.controller.scrap;

import com.app.kream.common.CommonResponse;
import com.app.kream.service.dto.ScrapCreateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "스크랩", description = "스크랩 관련 API 입니다.")
public interface ScrapControllerSwagger {
    @Operation(summary = "스크랩 상품 등록 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Scarp 생성에 성공했습니다."),
            //TODO
//            @ApiResponse(responseCode = "404",
//                    description = "1. Scrap 생성 실패.\n"
//            ),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류입니다.", content = @Content(schema = @Schema(implementation = CommonResponse.class)))
    })
    CommonResponse createScrap(
            ScrapCreateRequest request
    );

}
