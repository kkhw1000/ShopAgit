package com.hanul.shop.ShopAgit.discount.domain;

import lombok.Getter;

@Getter
public enum DiscountType {
    RATE(1),
    FIXED(2),
    COUPON(3);

    private final int priority;

    DiscountType(int priority) {
        this.priority = priority;
    }
}
