package com.hanul.shop.ShopAgit.discount.infrastructure;

import com.hanul.shop.ShopAgit.discount.domain.DiscountProductRule;

import java.util.List;
import java.util.Optional;

public interface DiscountProductRuleRepository {

    DiscountProductRule save(DiscountProductRule discountProductRule);
    List<DiscountProductRule> findByProductId(Long id);
    List<DiscountProductRule> findAll();
    void deleteById(Long id);
}
