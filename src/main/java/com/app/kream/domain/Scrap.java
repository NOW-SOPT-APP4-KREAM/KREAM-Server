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
@Table(
        name="Scrap",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "MEMBERID_PRODUCTID_UNIQUE",
                        columnNames= {"memberId","productId"}
                )
        }
)
public class Scrap extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private Long productId;
}
