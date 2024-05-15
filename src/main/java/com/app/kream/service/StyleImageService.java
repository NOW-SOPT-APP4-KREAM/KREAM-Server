package com.app.kream.service;

import com.app.kream.domain.Product;
import com.app.kream.domain.StyleImage;
import com.app.kream.repository.StyleImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StyleImageService {
    private final StyleImageRepository styleImageRepository;

    public List<StyleImage> findAllStyleImageById(
            final Product product
    ) {
        return styleImageRepository.findByProduct(product);
    }
}
