package com.modoostudy.mainStudy.responseCode.error;

public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
    INVALID_TYPE_VALUE(400, "C005", " Invalid Type Value"),


    // User
    EMAIL_DUPLICATION(400, "M001", "Email is Duplication"),
    NICKNAME_DUPLICATION(400, "M002", "NickName is Duplication");


    private int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }

}
