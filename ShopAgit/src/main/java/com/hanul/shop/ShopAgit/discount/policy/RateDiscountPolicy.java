package com.hanul.shop.ShopAgit.discount.policy;

public class RateDiscountPolicy implements DiscountPolicy{

    private final int value;
    public RateDiscountPolicy(int value) {
        this.value = value;
    }
    @Override
    public int apply(int price) {
        return price - (price * value / 100);
    }
}
