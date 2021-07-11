package com.modoostudy.mainStudy.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="mappingUserInterestTB")
@Getter
@Setter
@NoArgsConstructor
public class MappingUserInterest {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long muiID;

    @ManyToOne
    @JoinColumn(name="interestID")
    private Interest interest;

    @ManyToOne
    @JoinColumn(name="userID")
    private User user;



}
