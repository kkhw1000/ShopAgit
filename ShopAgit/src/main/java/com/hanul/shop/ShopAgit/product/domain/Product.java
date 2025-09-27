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
    private int stockQuantity;

    //TODO Order, OrderItem 만든 후 추후 다시 적용
/*    @ManyToOne
    private DiscountPolicyEntity discountPolicy;*/

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

        if (name == null) throw new NameMissingException(ErrorCode.MISSING_NAME);
        if (price <= 0) throw new InvalidPriceException(ErrorCode.INVALID_PRICE);
        if (stockQuantity <= 0 ) throw new InvalidStockException(ErrorCode.INVALID_STOCK);

        return new Product(name, price, stockQuantity);
    }


}
