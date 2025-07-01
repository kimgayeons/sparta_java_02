package com.sprata.java_02.global.config.exception;

import com.sprata.java_02.common.exception.ServiceException;
import com.sprata.java_02.common.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ServiceException.class)//ServiceException 에러가 생기면 아래 실행
  public ResponseEntity<?> handleResponseException(ServiceException ex) {
    return ApiResponse.error(ex.getCode(), ex.getMessage());
  }
}
