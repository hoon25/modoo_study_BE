package com.modoostudy.user.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="mappingEmblemTB")
@Getter
@Setter
@NoArgsConstructor
public class MappingEmblem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meID;

    @Column
    private Integer isUsed;

    @ManyToOne
    @JoinColumn(name="userID")
    private User user;

    @ManyToOne
    @JoinColumn(name="emblemID")
    private Emblem emblem;

    @Builder
    public MappingEmblem(User user, Emblem emblem) {
        this.user = user;
        this.emblem = emblem;
    }
}
