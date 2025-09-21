package com.hanul.shop.ShopAgit.discount;

import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import com.hanul.shop.ShopAgit.common.exception.InvalidDiscountPercentException;
import jakarta.persistence.DiscriminatorValue;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@DiscriminatorValue("RATE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RateDiscountPolicy extends DiscountPolicy {

    private int percent;

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
