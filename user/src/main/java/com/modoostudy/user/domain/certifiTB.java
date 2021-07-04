package com.modoostudy.user.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class certifiTB {

    @Id
    private Long ID;

    @Column
    private String certifiName;

    @Column
    private int approve;

    @ManyToOne
    @JoinColumn
    private userTB userTB;
}
