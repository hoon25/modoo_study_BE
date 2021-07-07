package com.modoostudy.OAuth2.responseCode.fail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
@NoArgsConstructor
public class ErrorResponse {

    private String message;
    private int status;
    private List<FieldError> errrors;
    private String code;

    @Getter
    @NoArgsConstructor
    public static class FieldError {
        private String field;
        private String value;
        private String reason;
    }

}
