package com.hanul.shop.ShopAgit.product.domain;

import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import com.hanul.shop.ShopAgit.common.exception.InvalidPriceException;
import com.hanul.shop.ShopAgit.common.exception.InvalidStockException;
import com.hanul.shop.ShopAgit.common.exception.NameMissingException;
import jakarta.persistence.*;
import lombok.Getter;

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
    private int stock;

    //JPA용
    protected Product() {
    }

    //Id 부여받지 못한 상태
    private Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


    //팩토리 메소드
    public static Product create(String name, int price, int stock) {

        if (name == null) throw new NameMissingException(ErrorCode.MISSING_NAME);
        if (price <= 0) throw new InvalidPriceException(ErrorCode.INVALID_PRICE);
        if (stock <= 0 ) throw new InvalidStockException(ErrorCode.INVALID_STOCK);

        return new Product(name, price, stock);
    }


}
