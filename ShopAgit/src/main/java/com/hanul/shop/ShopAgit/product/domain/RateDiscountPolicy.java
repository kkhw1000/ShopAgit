package com.hanul.shop.ShopAgit.product.domain;

import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import com.hanul.shop.ShopAgit.common.exception.InvalidDiscountPercentException;
import lombok.Getter;

@Getter
public class RateDiscountPolicy implements discountPolicy {

    private final int percent;

    private RateDiscountPolicy(int percent) {
        this.percent = percent;
    }

    @Override
    public int applyDiscount(int price) {
        return price - (price * percent / 100);
    }


    public static RateDiscountPolicy of(int percent) {
        if (percent < 1 || percent > 99) {
            throw new InvalidDiscountPercentException(ErrorCode.INVALID_DISCOUNT_PERCENT);
        }
        return new RateDiscountPolicy(percent);
    }
}
