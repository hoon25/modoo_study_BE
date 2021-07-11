package com.modoostudy.mainStudy.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "interest")
    private List<MappingUserInterest> mappingUserInterestList = new ArrayList<MappingUserInterest>();

    @OneToMany(mappedBy = "interest")
    private List<MappingStudyInterest> mappingStudyInterestList = new ArrayList<MappingStudyInterest>();

    @Builder
    public Interest(Long interestID) {
        this.interestID = interestID;
    }
    // 이곳이 PK로 쓰이진 않으므로 MappingStudyInterest와 interest는 단방향 참조
////    @OneToMany(mappedBy = "interest")
////    private List<MappingStudyInterest> interestNames = new ArrayList<>();




}
