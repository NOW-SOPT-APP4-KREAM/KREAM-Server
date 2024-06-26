package com.app.kream.repository;

import com.app.kream.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findTop12ByBrandTitleContainingIgnoreCaseOrTitleContainingIgnoreCaseOrEngTitleContainingIgnoreCase(String findName1,String findName2,String findName3);
    List<Product> findTop5ByEngTitleContainingIgnoreCaseOrTitleContainingIgnoreCaseOrderByIdDesc(String findName1,String findName2);
}
