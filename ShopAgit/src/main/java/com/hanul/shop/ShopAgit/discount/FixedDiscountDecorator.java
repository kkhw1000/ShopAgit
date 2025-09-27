package com.hanul.shop.ShopAgit.discount;

import com.hanul.shop.ShopAgit.discount.policy.DiscountPolicy;

public class FixedDiscountDecorator extends DiscountDecorator {

    public FixedDiscountDecorator(DiscountPolicy next, int value) {
        super(next,value);
    }

    @Override
    public int apply(int price) {
        return 0;
    }
}
