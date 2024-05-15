package com.app.kream.controller.scrap;

import com.app.kream.common.CommonResponse;
import com.app.kream.service.ScrapService;
import com.app.kream.service.dto.ScrapCreateRequest;
import com.app.kream.service.dto.ScrapDeleteRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scrap")
public class ScrapController implements ScrapControllerSwagger {

    private final ScrapService scrapService;

    @PostMapping
    public CommonResponse createScrap(
            @RequestHeader Long memberId,
            @RequestBody ScrapCreateRequest request
    ) {
        return scrapService.createScrap(
                memberId, request
        );
    }

    @DeleteMapping
    public CommonResponse deleteScrap(
            @RequestHeader Long memberId,
            @RequestBody ScrapDeleteRequest request
    ) {
        return scrapService.deleteScrap(
                memberId, request
        );
    }
}
