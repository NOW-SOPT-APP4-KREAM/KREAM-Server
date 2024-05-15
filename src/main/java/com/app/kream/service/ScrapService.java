package com.app.kream.service;

import com.app.kream.common.CommonResponse;
import com.app.kream.domain.Scrap;
import com.app.kream.exception.ErrorMessage;
import com.app.kream.exception.SuccessMessage;
import com.app.kream.exception.model.BusinessException;
import com.app.kream.repository.ScrapRepository;
import com.app.kream.service.dto.ScrapCreateRequest;
import com.app.kream.service.dto.ScrapDeleteRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;

@Service
@RequiredArgsConstructor
public class ScrapService {
    private final ScrapRepository scrapRepository;

    public CommonResponse createScrap(
            Long memberId,
            ScrapCreateRequest request
    ) {
        Scrap scrap = Scrap.builder()
                .memberId(memberId)
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

    public CommonResponse deleteScrap(Long memberId, ScrapDeleteRequest request) {
        Scrap scrap = scrapRepository.findByMemberIdAndProductId(
                        memberId,
                        request.productId()
                )
                .orElseThrow(
                        () -> new BusinessException(ErrorMessage.DELETE_SCRAP_FAILED)
                );
        scrapRepository.delete(scrap);
        return CommonResponse.success(SuccessMessage.DELETE_SCRAP_SUCCESS);
    }
}