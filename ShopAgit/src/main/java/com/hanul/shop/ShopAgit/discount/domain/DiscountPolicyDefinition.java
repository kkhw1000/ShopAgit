package com.hanul.shop.ShopAgit.discount.domain;

import com.hanul.shop.ShopAgit.common.exception.DomainException;
import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
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

    protected DiscountPolicyDefinition() {
    }

    private DiscountPolicyDefinition(DiscountType discountType, int value) {
        this.discountType = discountType;
        this.value = value;
    }

    public static DiscountPolicyDefinition create(DiscountType discountType, int value) {

        //도메인 규칙
        switch (discountType) {
            case RATE:
                if (value <= 0 || value > 100) throw new DomainException(ErrorCode.INVALID_DISCOUNT_PERCENT);
            case FIXED:
                if (value <= 0) throw new DomainException(ErrorCode.INVALID_DISCOUNT_VALUE);
            case COUPON:
                if (value <= 0) throw new DomainException(ErrorCode.INVALID_DISCOUNT_VALUE);
        }

        return new DiscountPolicyDefinition(discountType, value);
    }

}
