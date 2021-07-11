package com.modoostudy.mainStudy.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


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

    @OneToMany(mappedBy = "user")
    List<MappingStudyGuest> studyGuests;

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
