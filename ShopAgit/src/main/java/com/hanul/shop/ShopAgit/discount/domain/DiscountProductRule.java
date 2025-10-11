package com.hanul.shop.ShopAgit.discount.domain;

import com.hanul.shop.ShopAgit.product.domain.Product;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class DiscountProductRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private DiscountPolicyDefinition discountPolicyDefinition;


    LocalDate startAt;

    LocalDate endAt;

    protected DiscountProductRule() {}

    private DiscountProductRule(Product product, DiscountPolicyDefinition discountPolicyDefinition) {
        this.product = product;
        this.discountPolicyDefinition = discountPolicyDefinition;
    }

    public static DiscountProductRule create(Product product, DiscountPolicyDefinition discountPolicyDefinition) {

        //todo: 도메인 규칙 만들 것.

        return new DiscountProductRule(product, discountPolicyDefinition);
    }

}
