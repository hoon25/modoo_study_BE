package com.modoostudy.community.domain.entity;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userTB")
@Builder
@Data
@Entity
//@Getter
//@Setter
public class userTB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column
    private String nickname;

    @Column
    private String username;

    @Column
    private String GEmail;

    @Column
    private String userImage;
}
