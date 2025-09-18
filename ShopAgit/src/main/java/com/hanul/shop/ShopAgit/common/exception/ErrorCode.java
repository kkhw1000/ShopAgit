package com.hanul.shop.ShopAgit.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    MISSING_NAME(400,"MISSING_NAME","name은 null 일 수 없습니다."),
    INVALID_PRICE(400,"INVALID_PRICE","price 는 0 이하로 설정 할 수 없습니다."),
    INVALID_STOCK(400,"INVALID_STOCK" ,"stock 은 음수로 설정 할 수 없습니다." );


    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }


}
