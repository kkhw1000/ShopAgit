package com.hanul.shop.ShopAgit.discount;

import com.hanul.shop.ShopAgit.discount.policy.*;
import com.hanul.shop.ShopAgit.product.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DiscountService {


    public int calculateFinalPrice(Product product) {

        int price = product.getPrice();

        //첫 할인은 무조건 퍼센트 할인 먼저.
        DiscountPolicy discountPolicy = DiscountChainFactory.getDiscountPolicy(product.getPolicyEntities());

        int appliedPrice = discountPolicy.apply(price);
        if (appliedPrice < 0) {
            //TODO: 0보다 작을경우 throw
            log.error("Discount policy returned negative value");
            return price;
        } else return appliedPrice;
    }


}
