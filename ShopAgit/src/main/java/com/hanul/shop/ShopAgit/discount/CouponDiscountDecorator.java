package com.hanul.shop.ShopAgit.discount;

import com.hanul.shop.ShopAgit.discount.policy.DiscountPolicy;

public class CouponDiscountDecorator extends DiscountDecorator {

    public CouponDiscountDecorator(DiscountPolicy next, int value) {
        super(next, value);
    }

    @Override
    public int apply(int price) {
        return 0;
    }
}
