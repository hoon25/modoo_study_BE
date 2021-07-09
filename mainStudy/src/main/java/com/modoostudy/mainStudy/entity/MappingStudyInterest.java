package com.modoostudy.mainStudy.entity;

import lombok.Builder;
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
    Long msiID;

    @Column(nullable = false)
    Long interestID;

    @Column(nullable = false)
    Long studyID;

    @Builder
    public MappingStudyInterest(Long msiID, Long interestID, Long studyID) {
        this.msiID = msiID;
        this.interestID = interestID;
        this.studyID = studyID;
    }
}
