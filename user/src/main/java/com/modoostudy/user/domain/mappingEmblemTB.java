package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class mappingEmblemTB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne
    @JoinColumn
    private userTB userTB;

    @ManyToOne
    @JoinColumn
    private emblemTB emblemTB;
}
