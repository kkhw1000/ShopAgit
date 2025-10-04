package com.hanul.shop.ShopAgit.discount.policy;

import com.hanul.shop.ShopAgit.discount.CouponDiscountDecorator;
import com.hanul.shop.ShopAgit.discount.FixedDiscountDecorator;
import com.hanul.shop.ShopAgit.discount.RateDiscountDecorator;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DiscountChainFactory {


    public static DiscountPolicy getDiscountPolicy(List<DiscountPolicyEntity> discountPolicyEntity) {

        // 기본 베이스
        DiscountPolicy chain = new NoDiscountPolicy();

        //DB 레벨에서 순서는 정렬됨. 바로 읽어서 할 것.
        for (DiscountPolicyEntity discountPolicy : discountPolicyEntity) {
            int amount = discountPolicy.getValue();
            switch (discountPolicy.getDiscountType()) {
                case FIXED: {
                    chain = new FixedDiscountDecorator(chain, amount);
                    break;
                }
                case COUPON: chain = new CouponDiscountDecorator(chain, amount);
                case RATE: chain = new RateDiscountDecorator(chain, amount);
                default: log.info("미지원 할인 타입: {}", discountPolicy.getDiscountType());
            }
        }
        return chain;
    }

}
