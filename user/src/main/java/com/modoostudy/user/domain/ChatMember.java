package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="chatMemberTB")
@Getter
@Setter
public class ChatMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column
    private Long userID;

    @Column
    private Long chatID;

//    @ManyToOne
//    @JoinColumn(name="chatMember")
//    private userTB userTB;
//
//    @ManyToOne
//    @JoinColumn
//    private Chat Chat;

}
