package com.modoostudy.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class UserDto {

    private String userImage;
    private Long userID;
    private String nickname;
    private String GEmail;
    private Float grade;
    private List emblem;
    private String region;
    private List interests;
    private List certification;
    private String username;

    @Getter
    @NoArgsConstructor
    public static class UpdataImage {
        private String userImage;
    }
}
