package com.hanul.shop.ShopAgit.product.presentation;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductSummaryResponse {

    private final Long id;
    private final String name;
    private final int originalPrice;
    private final List<DiscountInfo> discountInfo;
    private final int discountedPrice;
    private final String thumbnailImgUrl;

}
