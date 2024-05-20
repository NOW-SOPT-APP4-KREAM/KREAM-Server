package com.app.kream.service;

import com.app.kream.domain.Product;
import com.app.kream.domain.StyleImage;
import com.app.kream.exception.ErrorMessage;
import com.app.kream.exception.model.NotFoundException;
import com.app.kream.repository.ProductRepository;
import com.app.kream.service.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        return DetailProductResponse.of(product, styleImages, scrapService.existByMemberIdAndProductId(memberId, productId));
    }

    public ReleaseProductResponse findReleaseProduct(
            final Long memberId
    ) {
        List<Product> products = findLimitCountProduct(12);

        return ReleaseProductResponse.of(
                products.stream()
                .map(product -> ReleaseProductInfoResponse.of(product, scrapService.existByMemberIdAndProductId(memberId, product.getId())))
                .toList()
        );
    }

    public RecommendProductResponse findRecommendProduct(
            final Long memberId
    ) {
        List<ForYouProductResponse> forYouProducts = ForYouProductResponse.convertForYouProductsToResponses(findLimitCountProduct(12));

        List<Product> products = findLimitCountProduct(5);
        List<JustDropProductResponse> justDropProducts = products.stream()
                        .map(product -> JustDropProductResponse.of(
                                product, scrapService.existByMemberIdAndProductId(
                                        memberId, product.getId())
                        ))
                        .toList();

        return RecommendProductResponse.of(forYouProducts, justDropProducts);
    }


    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public List<Product> findLimitCountProduct(
            final int count
    ) {
        return findAllProduct().stream()
                .limit(count)
                .toList();
    }

    public SearchProductResponse findSearchProduct(
            String findName
    ) {
        return SearchProductResponse.of(
                productRepository.findTop12ByBrandTitleContainingIgnoreCaseOrTitleContainingIgnoreCaseOrEngTitleContainingIgnoreCase(findName, findName, findName)
                        .stream()
                        .map(SearchFindProductResponse::of)
                        .collect(Collectors.toList()),
                productRepository.findTop5ByEngTitleContainingIgnoreCaseOrTitleContainingIgnoreCaseOrderByIdDesc(findName,findName)
                        .stream()
                        .map(RelateRecommendProductResponse::of)
                        .collect(Collectors.toList())
        );
    }

}
