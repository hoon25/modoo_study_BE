package com.modoostudy.OAuth2.controller;

import com.modoostudy.OAuth2.responseCode.error.ErrorCode;
import com.modoostudy.OAuth2.responseCode.error.ErrorResponse;
import com.modoostudy.OAuth2.responseCode.error.exception.BusinessException;
import com.modoostudy.OAuth2.responseCode.error.exception.DuplicateEmailException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionController {

    // 400
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException e){
        log.error("handleBusinessException 에러", e);
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }

}
