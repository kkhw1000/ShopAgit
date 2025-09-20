package com.hanul.shop.ShopAgit.common.exception;

import lombok.Getter;

@Getter
public class InvalidDiscountPercentException extends RuntimeException {

    private final ErrorCode errorCode;

    public InvalidDiscountPercentException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
