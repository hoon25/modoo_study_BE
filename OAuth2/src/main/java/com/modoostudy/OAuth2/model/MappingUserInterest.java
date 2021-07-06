package com.modoostudy.OAuth2.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
public class MappingUserInterest {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long ID;

    @Column
    Long interestID;

    @Column
    Long userID;

}
