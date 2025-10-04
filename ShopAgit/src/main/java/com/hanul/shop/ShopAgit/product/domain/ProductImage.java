package com.hanul.shop.ShopAgit.product.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column()
    private boolean isThumbnail;


    protected ProductImage() {
    }

    public void linkProduct(Product product) {
        this.product = product;
    }
}
