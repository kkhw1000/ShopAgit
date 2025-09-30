package com.hanul.shop.ShopAgit.product.domain;

import jakarta.persistence.*;

@Entity
public class ProductDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

}
