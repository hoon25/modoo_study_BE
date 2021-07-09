package com.modoostudy.mainStudy.responseCode.error.exception;

import com.modoostudy.OAuth2.responseCode.error.ErrorCode;

public class InvalidValueException extends BusinessException{

    public InvalidValueException(String value) {
        super(value, ErrorCode.INVALID_INPUT_VALUE);
    }

    public InvalidValueException(String value, ErrorCode errorCode) {
        super(value, errorCode);
    }


}
