package com.modoostudy.mainStudy.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="mappingStudyGuestTB")
@Getter
@Setter
@NoArgsConstructor
public class MappingStudyGuest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long msgID;

//    @Column(nullable = false)
//    private Long guestID;

//    @Column(nullable = false)
//    private Long studyID;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name="studyID")
    private Study study;

    @ManyToOne
    @JoinColumn(name="userID")
    private User user;



}
