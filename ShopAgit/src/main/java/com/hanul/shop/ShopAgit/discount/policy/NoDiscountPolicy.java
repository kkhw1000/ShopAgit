package com.hanul.shop.ShopAgit.discount.policy;

public class NoDiscountPolicy implements DiscountPolicy {


    @Override
    public int apply(int price) {
        return price;
    }
}
