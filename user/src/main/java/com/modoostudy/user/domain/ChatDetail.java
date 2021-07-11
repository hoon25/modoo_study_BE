package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="chatDetailsTB")
@Getter
@Setter
public class ChatDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column
    private String chatContents;

    @Column
    private LocalDateTime chatTime;

    @Column
    private String speaker;

    @Column
    private Long chatID;

//    @ManyToOne
//    @JoinColumn
//    private Chat Chat;

//    @ManyToOne
//    @JoinColumn(name="speaker")
//    private userTB userTB;


}
