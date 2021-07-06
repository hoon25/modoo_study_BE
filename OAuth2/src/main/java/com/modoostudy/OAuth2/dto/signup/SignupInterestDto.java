package com.modoostudy.OAuth2.dto.signup;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupInterestDto {
    Long interestId;
    Long userId;
}
