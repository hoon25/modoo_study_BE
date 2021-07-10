package com.modoostudy.mainStudy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="interestTB")
@Getter
@NoArgsConstructor
public class Interest {

    @Id
    private Long interestID;

    @Column(nullable = false)
    private String interestName;

    @Column(nullable = false)
    private String interestClassification;

    @OneToMany(mappedBy = "interest")
    private List<MappingStudyInterest> interestNames = new ArrayList<>();



}
