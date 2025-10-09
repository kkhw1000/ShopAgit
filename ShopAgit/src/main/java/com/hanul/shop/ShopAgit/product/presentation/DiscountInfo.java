package com.hanul.shop.ShopAgit.product.presentation;

import com.hanul.shop.ShopAgit.discount.domain.DiscountType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DiscountInfo {

    private final DiscountType type;
    private final double value;

}
