package com.app.kream.repository;

import com.app.kream.domain.Scrap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.Optional;

@Repository
public interface ScrapRepository extends JpaRepository<Scrap, Long> {
    boolean existsByMemberIdAndProductId(Long memberId, Long productId);
    Optional<Scrap> findByMemberIdAndProductId(Long memberId, Long productId);
}
