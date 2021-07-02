package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class emblemTB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emblemID;

    @Column
    private String emblemName;

}
