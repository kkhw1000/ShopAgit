package com.hanul.shop.ShopAgit.discount;

import com.hanul.shop.ShopAgit.discount.policy.DiscountPolicy;
import lombok.Getter;

@Getter
public abstract class DiscountDecorator implements DiscountPolicy {

    private final DiscountPolicy discountPolicy;
    private final int value;

    public DiscountDecorator(DiscountPolicy next, int value) {
        this.discountPolicy = next;
        this.value = value;
    }


}
