package com.pinku.restaurant.api.advice;

import com.pinku.restaurant.api.dto.CustomErrorResponse;
import com.pinku.restaurant.api.dto.GlobalErrorCode;
import com.pinku.restaurant.api.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestaurantServiceGlobalExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<?> handleOrderNotFountException(OrderNotFoundException ex){
        CustomErrorResponse errorResponse = new CustomErrorResponse().builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .errorCode(GlobalErrorCode.ERROR_ORDER_NOT_FOUND)
                .errorMessage(ex.getMessage())
                .build();
        System.out.println("loging statement");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);

    }
}
