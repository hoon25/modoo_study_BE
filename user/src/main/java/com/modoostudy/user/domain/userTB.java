package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class userTB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @Column
    private String nickname;

    @Column
    private String username;

    @Column
    private String GEmail;

    @Column
    private String userImage;

}
