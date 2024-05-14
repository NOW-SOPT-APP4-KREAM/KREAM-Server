package com.app.kream.service;

import com.app.kream.domain.Product;
import com.app.kream.domain.StyleImage;
import com.app.kream.exception.ErrorMessage;
import com.app.kream.exception.model.NotFoundException;
import com.app.kream.repository.ProductRepository;
import com.app.kream.service.dto.DetailProductResponse;
import com.app.kream.service.dto.ReleaseProductInfoResponse;
import com.app.kream.service.dto.ReleaseProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final MemberService memberService;
    private final ScrapService scrapService;
    private final StyleImageService styleImageService;

    public Product findProductById(
        final Long productId
    ) {
        return productRepository.findById(productId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND)
        );
    }

    public DetailProductResponse findDetailProductById(
            final Long memberId,
            final Long productId
    ) {
        memberService.getMemberById(memberId);
        Product product = findProductById(productId);
        List<StyleImage> styleImages = styleImageService.findAllStyleImageById(product);
        return DetailProductResponse.of(product, styleImages);
    }
}
