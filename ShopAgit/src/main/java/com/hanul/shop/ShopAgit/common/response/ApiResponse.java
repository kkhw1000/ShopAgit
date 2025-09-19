package com.hanul.shop.ShopAgit.common.response;

import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiResponse<T> {

    private final boolean success;
    private final int status;
    private final T data;
    private final String message;
    private final LocalDateTime timestamp;

    public ApiResponse(T data, boolean success, int status, String message) {
        this.data = data;
        this.success = success;
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, true, 200, null);
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(data, true, 200, message);
    }
    public static <T> ApiResponse<T> error(ErrorCode errorCode) {
        return new ApiResponse<>(null,false,errorCode.getStatus(), errorCode.getMessage());
    }

}
