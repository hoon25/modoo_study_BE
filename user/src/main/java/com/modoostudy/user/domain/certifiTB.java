package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class certifiTB {

    @Id
    private Long ID;

    @Column
    private String certifiName;

    @Column
    private int approve;

    @ManyToOne
    @JoinColumn
    private userTB userTB;
}
