package com.hanul.shop.ShopAgit.common.exception;

import lombok.Getter;

@Getter
public class InvalidStockException extends RuntimeException {

    private final ErrorCode errorCode;

    public InvalidStockException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
