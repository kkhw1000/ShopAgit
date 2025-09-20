package com.hanul.shop.ShopAgit.product.presentation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductSummaryResponse {

    private final Long id;
    private final String name;
    private final int originalPrice;
    private final int discountPercent;
    private final int discountPrice;

}
