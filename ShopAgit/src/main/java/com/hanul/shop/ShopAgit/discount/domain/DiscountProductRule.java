package com.hanul.shop.ShopAgit.discount.domain;

import com.hanul.shop.ShopAgit.common.exception.DomainException;
import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
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


    private LocalDate startAt;

    private LocalDate endAt;

    protected DiscountProductRule() {}

    private DiscountProductRule(Product product, DiscountPolicyDefinition discountPolicyDefinition, LocalDate startAt, LocalDate endAt) {
        this.product = product;
        this.discountPolicyDefinition = discountPolicyDefinition;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public static DiscountProductRule create(Product product, DiscountPolicyDefinition discountPolicyDefinition, LocalDate startAt, LocalDate endAt) {


        if (startAt.isAfter(endAt)) throw new DomainException(ErrorCode.INVALID_START_DATE);

        return new DiscountProductRule(product, discountPolicyDefinition, startAt, endAt);
    }

}
