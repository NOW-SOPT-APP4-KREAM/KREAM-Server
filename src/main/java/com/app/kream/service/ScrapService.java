package com.app.kream.service;

import com.app.kream.common.CommonResponse;
import com.app.kream.domain.Scrap;
import com.app.kream.exception.SuccessMessage;
import com.app.kream.repository.ScrapRepository;
import com.app.kream.service.dto.ScrapCreateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScrapService {
    private final ScrapRepository scrapRepository;

    @Transactional
    public CommonResponse createScrap(
            ScrapCreateRequest request
    ) {
        Scrap scrap = Scrap.builder()
                .memberId(request.memberId())
                .productId(request.productId())
                .build();

        scrapRepository.save(scrap);
        return CommonResponse.success(SuccessMessage.PROCESS_SUCCESS);
    }

    public Boolean existByMemberIdAndProductId(
            final Long memberId,
            final Long productId
    ) {
        return scrapRepository.existsByMemberIdAndProductId(memberId, productId);
    }
}