package com.modoostudy.OAuth2.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="mappingUserInterestTB")
@Getter
@Setter
@NoArgsConstructor
public class MappingUserInterest {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long muiID;

    @Column(nullable = false)
    Long interestID;

    @Column(nullable = false)
    Long userID;

    @Builder
    public MappingUserInterest(Long muiID, Long interestID, Long userID) {
        this.muiID = muiID;
        this.interestID = interestID;
        this.userID = userID;
    }
}
