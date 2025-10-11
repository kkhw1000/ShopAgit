package com.hanul.shop.ShopAgit.discount.domain;

import com.hanul.shop.ShopAgit.product.domain.Product;

public interface DiscountPolicy {
    DiscountType getType();
    int apply(int price, int value);
}
