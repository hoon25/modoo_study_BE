package com.modoostudy.OAuth2.responseCode.error.exception;

import com.modoostudy.OAuth2.responseCode.error.ErrorCode;

public class DuplicateEmailException extends BusinessException {

    public DuplicateEmailException(String message){
        super(message, ErrorCode.EMAIL_DUPLICATION);
    }

    public DuplicateEmailException(String value, ErrorCode errorCode) {
        super(value, errorCode);
    }

}
