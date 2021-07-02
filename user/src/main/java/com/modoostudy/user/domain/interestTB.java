package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class interestTB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestID;

    @Column
    private String interestName;

}
