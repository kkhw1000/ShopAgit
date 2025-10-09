package com.hanul.shop.ShopAgit.discount;

import com.hanul.shop.ShopAgit.discount.infrastructure.DiscountRepository;
import com.hanul.shop.ShopAgit.discount.domain.DiscountPolicy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiscountService {

    private final Map<String, DiscountPolicy> policyMap;
    private final DiscountRepository discountRepository;

}
