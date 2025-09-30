package com.hanul.shop.ShopAgit.discount;

import com.hanul.shop.ShopAgit.discount.policy.DiscountPolicy;
import com.hanul.shop.ShopAgit.discount.policy.DiscountPolicyEntity;
import com.hanul.shop.ShopAgit.discount.policy.DiscountType;
import com.hanul.shop.ShopAgit.discount.policy.RateDiscountPolicy;

import java.util.List;

public class DiscountFactory {


    public static DiscountDecorator createDiscountDecorator(List<DiscountPolicy> discountPolicies) {

        return new FixedDiscountDecorator(
                new CouponDiscountDecorator(
                        new RateDiscountPolicy(1),1
                ),1
                );
    }


}
