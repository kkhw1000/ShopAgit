package com.hanul.shop.ShopAgit.discount;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("FIXED")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FixedDiscountPricePolicy extends DiscountPolicy {

    private int fixedDiscount;

    public FixedDiscountPricePolicy(int fixedDiscount) {
        this.fixedDiscount = fixedDiscount;
    }

    @Override
    public int applyDiscount(int price) {
        if (price < fixedDiscount) {

        }
        return price - fixedDiscount;
    }
}
