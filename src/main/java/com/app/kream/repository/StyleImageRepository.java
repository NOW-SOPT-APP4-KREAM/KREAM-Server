package com.app.kream.repository;

import com.app.kream.domain.Product;
import com.app.kream.domain.Scrap;
import com.app.kream.domain.StyleImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StyleImageRepository extends JpaRepository<StyleImage, Long> {
    List<StyleImage> findByProduct(Product product);
}
