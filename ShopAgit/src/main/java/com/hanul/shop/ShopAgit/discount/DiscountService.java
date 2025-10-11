package com.hanul.shop.ShopAgit.discount;

import com.hanul.shop.ShopAgit.discount.domain.DiscountPolicyDefinition;
import com.hanul.shop.ShopAgit.discount.domain.DiscountProductRule;
import com.hanul.shop.ShopAgit.discount.domain.DiscountType;
import com.hanul.shop.ShopAgit.discount.infrastructure.DiscountProductRuleRepository;
import com.hanul.shop.ShopAgit.discount.domain.DiscountPolicy;
import com.hanul.shop.ShopAgit.product.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@Slf4j
@RequiredArgsConstructor
public class DiscountService {

    private final Map<DiscountType, DiscountPolicy> policyMap;
    private final DiscountProductRuleRepository discountRuleRepository;

    public List<DiscountProductRule> findByProductId(Product product) {
        return discountRuleRepository.findByProductId(product.getId());
    }

    public int calculateDiscount(Product product) {
        int calculatedPrice = product.getPrice();
        List<DiscountProductRule> discountProductRules = discountRuleRepository.findByProductId(product.getId());
        
        //할인 로직
        for (DiscountProductRule discountProductRule : discountProductRules) {
            
            //할인 이벤트 정보
            DiscountPolicyDefinition discountPolicyInfo = discountProductRule.getDiscountPolicyDefinition();
            DiscountType DiscountType = discountPolicyInfo.getDiscountType();
            int discountValue = discountPolicyInfo.getValue();
            
            //할인 적용
            DiscountPolicy productDiscountPolicy = policyMap.get(DiscountType);
            if (productDiscountPolicy != null) {
                calculatedPrice = productDiscountPolicy.apply(calculatedPrice, discountValue);
            }
        }
        return calculatedPrice;
    }

}
