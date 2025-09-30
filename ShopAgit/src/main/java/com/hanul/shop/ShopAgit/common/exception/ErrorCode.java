package com.hanul.shop.ShopAgit.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    //Validation Errors
    MISSING_NAME(400,"MISSING_NAME","상품명은 필수 입니다."),
    INVALID_PRICE(400,"INVALID_PRICE","상품 가격은 1원 이상이어야 합니다."),
    INVALID_STOCK(400,"INVALID_STOCK" ,"재고는 음수 일 수 없습니다."),
    INVALID_COUNT(400,"INVALID_COUNT" ,"주문 수량은 1개 이상이어야 합니다."),
    INVALID_DISCOUNT_PERCENT(400,"INVALID_DISCOUNT_PERCENT" ,"할인율은 1 ~ 99 사이여야 합니다." ),
    CANNOT_CHANGE_STATUS(400,"CANNOT_CHANGE_STATUS" ,"주문 상태를 변경 할 수 없습니다." ),
    //TODO 더 복잡해 지면 세분화할것. ex) CANNOT_CANCEL_DELIVERED_ORDER 등...


    //NotFound Errors
    PRODUCT_NOT_FOUND(404, "PRODUCT_NOTFOUND", "Product를 찾지 못 했습니다."),
    MEMBER_NOT_FOUND(404, "MEMBER_NOT_FOUND", "Member를 찾지 못 했습니다."),
    ORDER_ITEM_NOT_FOUND(404, "ORDER_ITEM_NOT_FOUND", "OrderItem을 찾지 못 했습니다.");


    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }


}
