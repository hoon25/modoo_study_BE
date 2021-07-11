package com.modoostudy.user.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="emblemTB")
@Getter
@Setter
@NoArgsConstructor
public class Emblem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emblemID;

    @Column
    private String emblemName;

    @Builder
    public Emblem(Long emblemID, String emblemName) {
        this.emblemID = emblemID;
        this.emblemName = emblemName;
    }
}
