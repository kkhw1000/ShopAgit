package com.hanul.shop.ShopAgit.discount.infrastructure;

import com.hanul.shop.ShopAgit.discount.domain.DiscountProductRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDiscountProductRuleRepository extends DiscountProductRuleRepository, JpaRepository<DiscountProductRule, Long> {

}
