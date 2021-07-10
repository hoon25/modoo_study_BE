package com.modoostudy.mainStudy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="mappingStudyInterestTB")
@Getter
@Setter
@NoArgsConstructor
public class MappingStudyInterest {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long msiID;

//    @Column(nullable = false)
//    private Long interestID;

//    @Column(nullable = false)
//    private Long studyID;

    @ManyToOne
    @JoinColumn(name="interestID")
    private Interest interest;

    @ManyToOne
    @JoinColumn(name="studyID")
    private Study study;


//    @Builder
//    public MappingStudyInterest(Long msiID, Long interestID, Long studyID) {
//        this.msiID = msiID;
//        this.interestID = interestID;
//        this.studyID = studyID;
//    }
}
