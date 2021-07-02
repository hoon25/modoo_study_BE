package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class notificationTB {
    @ManyToOne
    @JoinColumn
    private userTB userTB;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column
    private String notification;

    @Column
    private boolean read;

}
