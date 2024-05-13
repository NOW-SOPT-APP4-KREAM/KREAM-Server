package com.app.kream.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String thumbnailUrl;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String engTitle;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String recentPrice;

    @Column(nullable = false)
    private String variablePrice;

    @Column(nullable = false)
    private String variablePercent;

    @Column(nullable = false)
    private String releasePrice;

    @Column(nullable = false)
    private String modelNumber;

    @Column(nullable = false)
    private String releaseDate;

    @Column(nullable = false)
    private String styleCount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Column(nullable = false)
    private String transactionCount;

    @Column(nullable = false)
    private String mentionCount;

    @Column(nullable = false)
    private String brandTitle;

    @Column(nullable = false)
    private boolean isFast;

}
