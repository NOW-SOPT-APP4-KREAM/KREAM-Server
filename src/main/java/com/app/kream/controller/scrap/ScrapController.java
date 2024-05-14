package com.app.kream.controller.scrap;

import com.app.kream.common.CommonResponse;
import com.app.kream.service.ScrapService;
import com.app.kream.service.dto.ScrapCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scrap")
public class ScrapController implements ScrapControllerSwagger {

    private final ScrapService scrapService;

    @PostMapping
    public CommonResponse createScrap(
            ScrapCreateRequest request
    ) {
        return scrapService.createScrap(
                request
        );
    }
}
