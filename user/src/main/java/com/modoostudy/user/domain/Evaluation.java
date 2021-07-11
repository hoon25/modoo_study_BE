package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="evaluationTB")
@Getter
@Setter
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column
    private int score;

    @Column
    private String comment;

    @Column
    private Long userID;

//    @ManyToOne
//    @JoinColumn
//    private userTB userTB;
}
