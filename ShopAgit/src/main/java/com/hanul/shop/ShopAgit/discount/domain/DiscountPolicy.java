package com.hanul.shop.ShopAgit.discount.domain;

public interface DiscountPolicy {
    int apply(int price, int value);
}
