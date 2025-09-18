package com.hanul.shop.ShopAgit.common.exception;


import lombok.Getter;

@Getter
public class NameMissingException extends RuntimeException {

    private final ErrorCode errorCode;
    public NameMissingException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }


}
