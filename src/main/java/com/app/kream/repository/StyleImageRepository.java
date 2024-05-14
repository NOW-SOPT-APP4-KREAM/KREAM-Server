package com.app.kream.repository;

import com.app.kream.domain.Product;
import com.app.kream.domain.Scrap;
import com.app.kream.domain.StyleImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StyleImageRepository extends JpaRepository<StyleImage, Long> {
    List<StyleImage> findByProduct(Product product);
}
