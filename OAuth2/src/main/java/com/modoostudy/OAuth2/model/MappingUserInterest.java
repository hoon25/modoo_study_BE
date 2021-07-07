package com.modoostudy.OAuth2.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="mappingUserInterestTB")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class MappingUserInterest {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long ID;

    @Column
    Long interestID;

    @Column
    Long userID;

    @Builder
    public MappingUserInterest(Long ID, Long interestID, Long userID) {
        this.ID = ID;
        this.interestID = interestID;
        this.userID = userID;
    }


}
