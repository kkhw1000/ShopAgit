package com.hanul.shop.ShopAgit.common.exception;

import lombok.Getter;

@Getter
public class InvalidDisCountPercentException extends RuntimeException {

    private final ErrorCode errorCode;

    public InvalidDisCountPercentException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
