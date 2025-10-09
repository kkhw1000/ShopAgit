package com.hanul.shop.ShopAgit.product.domain;

import com.hanul.shop.ShopAgit.common.exception.DomainException;
import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stockQuantity;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> images = new ArrayList<>();

    //JPA용
    protected Product() {
    }

    private Product(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    //팩토리 메소드
    public static Product create(String name, int price, int stockQuantity) {

        if (name == null) throw new DomainException(ErrorCode.MISSING_NAME);
        else if (price <= 0) throw new DomainException(ErrorCode.INVALID_PRICE);
        else if (stockQuantity <= 0 ) throw new DomainException(ErrorCode.INVALID_STOCK);

        return new Product(name, price, stockQuantity);
    }

    public void addImage(ProductImage productImage) {
        images.add(productImage);
        productImage.linkProduct(this);
    }



}
