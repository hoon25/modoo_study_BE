package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class evaluationTB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column
    private int score;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn
    private userTB userTB;
}
