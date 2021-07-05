package com.modoostudy.OAuth2.domain;


import lombok.Data;
import javax.persistence.*;


@Entity
@Table(name="userTB")
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userID;

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

}
