package com.app.kream.service;

import com.app.kream.domain.Product;
import com.app.kream.exception.ErrorMessage;
import com.app.kream.exception.model.NotFoundException;
import com.app.kream.repository.ProductRepository;
import com.app.kream.service.dto.DetailProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final MemberService memberService;

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
        return DetailProductResponse.of(product);
    }
}
