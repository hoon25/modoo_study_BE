package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class chatMemberTB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column
    private String chatMember;

    @ManyToOne
    @JoinColumn
    private chatTB chatTB;

}
