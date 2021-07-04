package com.modoostudy.user.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
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

    @OneToMany(mappedBy = "userTB")
    private List<certifiTB> certification;
}
