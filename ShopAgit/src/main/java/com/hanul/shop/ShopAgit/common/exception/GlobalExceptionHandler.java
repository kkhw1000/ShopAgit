package com.hanul.shop.ShopAgit.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(InvalidPriceException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPrice(InvalidPriceException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getCode(), e.getMessage());
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(NameMissingException.class)
    public ResponseEntity<ErrorResponse> handleNameMissing(NameMissingException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getCode(), e.getMessage());
        return  ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(InvalidStockException.class)
    public ResponseEntity<ErrorResponse> handleInvalidStock(InvalidStockException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getCode(), e.getMessage());
        return  ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(errorResponse);
    }


}
