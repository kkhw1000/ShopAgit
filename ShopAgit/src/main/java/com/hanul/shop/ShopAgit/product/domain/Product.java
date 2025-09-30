package com.hanul.shop.ShopAgit.product.domain;

import com.hanul.shop.ShopAgit.common.exception.DomainException;
import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import com.hanul.shop.ShopAgit.discount.policy.DiscountPolicyEntity;
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

    //TODO LAZY -> N+1 문제 추후 해결 할 것.
    @OneToMany(mappedBy = "product")
    private List<DiscountPolicyEntity> policyEntities = new ArrayList<>();

    //JPA용
    protected Product() {
    }

    private Product(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    private Product(String name, int price, int stockQuantity, List<DiscountPolicyEntity> policyEntities) {
        this(name, price, stockQuantity);
        for (DiscountPolicyEntity policyEntity : policyEntities) {
            this.addPolicy(policyEntity);
        }
    }


    //팩토리 메소드
    public static Product create(String name, int price, int stockQuantity) {

        if (name == null) throw new DomainException(ErrorCode.MISSING_NAME);
        else if (price <= 0) throw new DomainException(ErrorCode.INVALID_PRICE);
        else if (stockQuantity <= 0 ) throw new DomainException(ErrorCode.INVALID_STOCK);

        return new Product(name, price, stockQuantity);
    }

    public static Product create(String name, int price, int stockQuantity, List<DiscountPolicyEntity> policyEntities) {

        if (name == null) throw new DomainException(ErrorCode.MISSING_NAME);
        else if (price <= 0) throw new DomainException(ErrorCode.INVALID_PRICE);
        else if (stockQuantity <= 0 ) throw new DomainException(ErrorCode.INVALID_STOCK);

        return new Product(name, price, stockQuantity,policyEntities);
    }

    public void addPolicy(DiscountPolicyEntity policyEntity) {
        policyEntities.add(policyEntity);
        policyEntity.linkProduct(this);
    }



}
