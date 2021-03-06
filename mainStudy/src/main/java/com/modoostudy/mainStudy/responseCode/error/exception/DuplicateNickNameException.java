package com.modoostudy.mainStudy.responseCode.error.exception;

import com.modoostudy.mainStudy.responseCode.error.ErrorCode;

public class DuplicateNickNameException extends BusinessException {

    public DuplicateNickNameException(String message){
        super(message, ErrorCode.NICKNAME_DUPLICATION);
    }

    public DuplicateNickNameException(String value, ErrorCode errorCode) {
        super(value, errorCode);
    }

}
