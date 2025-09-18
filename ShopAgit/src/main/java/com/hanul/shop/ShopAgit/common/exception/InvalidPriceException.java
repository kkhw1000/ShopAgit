package com.hanul.shop.ShopAgit.common.exception;

import lombok.Getter;

@Getter
public class InvalidPriceException extends RuntimeException {

    private final ErrorCode errorCode;

    public InvalidPriceException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
