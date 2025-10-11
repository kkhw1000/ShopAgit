package com.hanul.shop.ShopAgit.discount.domain;

import com.hanul.shop.ShopAgit.product.domain.Product;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class DiscountPolicyDefinition {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private int value;

    protected DiscountPolicyDefinition() {}

    private DiscountPolicyDefinition(DiscountType discountType, int value) {
        this.discountType = discountType;
        this.value = value;
    }

    public static DiscountPolicyDefinition create(DiscountType discountType, int value) {
        
        //todo 도메인 규칙만들것
        
        return  new DiscountPolicyDefinition(discountType, value);
    }

}
