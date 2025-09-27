package com.hanul.shop.ShopAgit.discount;

import com.hanul.shop.ShopAgit.discount.policy.DiscountPolicyEntity;
import com.hanul.shop.ShopAgit.discount.policy.DiscountType;
import com.hanul.shop.ShopAgit.discount.policy.RateDiscountPolicy;

public class DiscountFactory {


    public static DiscountDecorator createDiscountDecorator(DiscountType discountType){

        return new FixedDiscountDecorator(
                new CouponDiscountDecorator(
                        new RateDiscountPolicy(1),1
                ),1
                );
    }


}
