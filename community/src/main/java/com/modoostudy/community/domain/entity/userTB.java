package com.modoostudy.community.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userTB")
@Builder
@Data
@Entity

public class userTB {
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

    @JsonBackReference
    @OneToMany(mappedBy = "userTB", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<communityTB> writerID;

    @Builder
    public userTB(Long userID, String password, String nickname, String region, String GEmail, String userImage, int authorities) {
        this.userID = userID;
        this.password = password;
        this.nickname = nickname;
        this.region = region;
        this.GEmail = GEmail;
        this.userImage = userImage;
        this.authorities = authorities;
    }
}
