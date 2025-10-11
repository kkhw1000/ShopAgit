package com.hanul.shop.ShopAgit.discount.policy;

import com.hanul.shop.ShopAgit.discount.domain.DiscountPolicy;
import com.hanul.shop.ShopAgit.discount.domain.DiscountType;
import org.springframework.stereotype.Component;

@Component("rate")
public class RateDiscount implements DiscountPolicy {


    @Override
    public DiscountType getType() {
        return DiscountType.RATE;
    }

    @Override
    public int apply(int price, int value) {
        return price - (price * value / 100);
    }
}
