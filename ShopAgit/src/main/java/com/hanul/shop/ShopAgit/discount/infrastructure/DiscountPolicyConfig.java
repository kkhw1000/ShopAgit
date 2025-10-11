package com.hanul.shop.ShopAgit.discount.infrastructure;

import com.hanul.shop.ShopAgit.discount.domain.DiscountPolicy;
import com.hanul.shop.ShopAgit.discount.domain.DiscountType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class DiscountPolicyConfig {

    private final List<DiscountPolicy> discountPolicies;

    @Bean
    public Map<DiscountType, DiscountPolicy> discountPolicyMap() {
        Map<DiscountType, DiscountPolicy> map = new HashMap<>();

        for (DiscountPolicy discountPolicy : discountPolicies) {
            map.put(discountPolicy.getType(), discountPolicy);
        }

        return map;
    }

}
