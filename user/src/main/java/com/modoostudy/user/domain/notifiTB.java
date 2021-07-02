package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class notifiTB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column
    private String noti;

    @Column
    private Long read_check;

    @ManyToOne
    @JoinColumn
    private userTB userTB;
}
