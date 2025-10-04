package com.hanul.shop.ShopAgit.discount;

import com.hanul.shop.ShopAgit.common.exception.DomainException;
import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import com.hanul.shop.ShopAgit.discount.policy.DiscountPolicy;

public class RateDiscountDecorator implements DiscountPolicy {

    private final DiscountPolicy discountPolicy;
    private final int percent;

    public RateDiscountDecorator(DiscountPolicy discountPolicy, int percent) {
        this.discountPolicy = discountPolicy;
        if (percent <= 0 || percent > 100) throw new DomainException(ErrorCode.INVALID_DISCOUNT_PERCENT);
        this.percent = percent;
    }

    @Override
    public int apply(int price) {
        int appliedPrice = discountPolicy.apply(price);
        return appliedPrice - (appliedPrice * percent / 100);
    }
}
