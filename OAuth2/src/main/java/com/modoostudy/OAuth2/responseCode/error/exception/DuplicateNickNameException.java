package com.modoostudy.OAuth2.responseCode.error.exception;

import com.modoostudy.OAuth2.responseCode.error.ErrorCode;

public class DuplicateNickNameException extends BusinessException {

    public DuplicateNickNameException(String message){
        super(message, ErrorCode.NICKNAME_DUPLICATION);
    }

    public DuplicateNickNameException(String value, ErrorCode errorCode) {
        super(value, errorCode);
    }

}
