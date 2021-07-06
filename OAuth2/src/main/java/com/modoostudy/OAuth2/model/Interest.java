package com.modoostudy.OAuth2.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="interestTB")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Interest {

    @Id
    private Long interestID;

    @Column(nullable = false)
    private String interestName;

    @Column(nullable = false)
    private String interestClassification;

//    @Builder
//    public Interest(Long interestID, String interestName, String interestClassification) {
//        this.interestID = interestID;
//        this.interestName = interestName;
//        this.interestClassification = interestClassification;
//    }


}
