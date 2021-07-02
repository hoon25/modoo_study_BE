package com.modoostudy.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class chatTB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatID;

    @Column
    private String chatName;

    @Column
    private LocalDateTime lastTime;

}
