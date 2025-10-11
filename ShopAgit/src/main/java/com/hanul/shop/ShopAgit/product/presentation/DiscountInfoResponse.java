package com.hanul.shop.ShopAgit.product.presentation;

import com.hanul.shop.ShopAgit.discount.domain.DiscountType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DiscountInfoResponse {

    private final String    type;
    private final double value;

}
