package com.modoostudy.mainStudy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="interestTB")
@Setter
@Getter
@NoArgsConstructor
public class Interest {

    @Id
    private Long interestID;

    @Column(nullable = false)
    private String interestName;

    @Column(nullable = false)
    private String interestClassification;

    // 이곳이 PK로 쓰이진 않으므로 MappingStudyInterest와 interest는 단방향 참조
//    @OneToMany(mappedBy = "interest")
//    private List<MappingStudyInterest> interestNames = new ArrayList<>();



}
