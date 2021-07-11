package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="notifiTB")
@Getter
@Setter
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column
    private String noti;

    @Column
    private Long read_check;

    @Column
    private Long userID;
//    @ManyToOne
//    @JoinColumn
//    private userTB userTB;
}
