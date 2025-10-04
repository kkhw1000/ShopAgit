package com.hanul.shop.ShopAgit.discount;

import com.hanul.shop.ShopAgit.common.exception.DomainException;
import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import com.hanul.shop.ShopAgit.discount.policy.DiscountPolicy;

public class CouponDiscountDecorator implements DiscountPolicy {

    private final DiscountPolicy discountPolicy;
    private final int amount;

    public CouponDiscountDecorator(DiscountPolicy discountPolicy, int amount) {
        this.discountPolicy = discountPolicy;
        if (amount <= 0) throw new DomainException(ErrorCode.INVALID_DISCOUNT_VALUE);
        this.amount = amount;
    }

    @Override
    public int apply(int price) {
        int appliedPrice = discountPolicy.apply(price);
        return appliedPrice - amount;
    }
}
