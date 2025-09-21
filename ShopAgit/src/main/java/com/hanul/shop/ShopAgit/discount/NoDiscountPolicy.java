package com.hanul.shop.ShopAgit.discount;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("NONE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoDiscountPolicy extends DiscountPolicy {

    @Override
    public int applyDiscount(int price) {
        return price;
    }


}
