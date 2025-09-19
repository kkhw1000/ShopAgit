package com.hanul.shop.ShopAgit.product.presentation;

import lombok.Builder;

@Builder
public class ProductSummaryResponse {

    private final Long id;
    private final String name;
    private final int price;

}
