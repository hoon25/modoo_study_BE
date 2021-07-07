package com.modoostudy.OAuth2.entity;


import lombok.*;

import javax.persistence.*;


//@Entity
//@Table(name="userTB")
//@Data

@Entity
@Table(name="userTB")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userID;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 20, nullable = false)
    private String region;

    @Column(length = 20, nullable = false)
    private String GEmail;

    @Column(length = 40)
    private String userImage;

    @Column(length = 20, nullable = false)
    private int authorities;

    @Builder
    public User(Long userID, String password, String nickname, String region, String GEmail, String userImage, int authorities) {
        this.userID = userID;
        this.password = password;
        this.nickname = nickname;
        this.region = region;
        this.GEmail = GEmail;
        this.userImage = userImage;
        this.authorities = authorities;
    }
}
