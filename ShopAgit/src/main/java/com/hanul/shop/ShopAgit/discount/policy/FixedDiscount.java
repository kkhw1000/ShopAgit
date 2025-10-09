package com.hanul.shop.ShopAgit.discount.policy;

import com.hanul.shop.ShopAgit.discount.domain.DiscountPolicy;
import org.springframework.stereotype.Component;

@Component("fixed")
public class FixedDiscount implements DiscountPolicy {


    @Override
    public int apply(int price, int value) {
        return price - value;
    }

}
