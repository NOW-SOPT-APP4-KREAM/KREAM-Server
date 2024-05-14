package com.app.kream.repository;

import com.app.kream.domain.Scrap;
import com.app.kream.domain.StyleImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleImageRepository extends JpaRepository<StyleImage, Long> {
}
