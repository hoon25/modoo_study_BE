package com.modoostudy.mainStudy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="studyTB")
@Getter
@Setter
@NoArgsConstructor
public class Study{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyID;

//    @Column(nullable = false)
//    private Long hostID;
    @OneToOne
    @JoinColumn(name="hostID", referencedColumnName = "userID")
    User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate periodStart;

    @Column(nullable = false)
    private LocalDate periodEnd;

    @Column(nullable = false)
    private String goal;

    @Column(nullable = false)
    private String need;

    @Column(nullable = false)
    private String onoffline;

    @Column(nullable = false)
    private Long needPeople;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private String studyStatus;


    @OneToMany(mappedBy = "study")
    private List<MappingStudyInterest> studyInterests = new ArrayList<MappingStudyInterest>();

    @OneToMany(mappedBy = "study")
    private List<MappingStudyGuest> studyGuests = new ArrayList<MappingStudyGuest>();
    }

