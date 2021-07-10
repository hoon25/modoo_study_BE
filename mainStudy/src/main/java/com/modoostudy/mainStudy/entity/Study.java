package com.modoostudy.mainStudy.entity;

import lombok.Builder;
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

    @Column(nullable = false)
    private Long hostID;

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


    @OneToMany(mappedBy = "study")
    private List<MappingStudyInterest> studyInterests = new ArrayList<>();


    @Builder
    public Study(Long studyID, Long hostID, String title, LocalDate periodStart, LocalDate periodEnd, String goal, String need, String onoffline, Long needPeople, String details) {
        this.studyID = studyID;
        this.hostID = hostID;
        this.title = title;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.goal = goal;
        this.need = need;
        this.onoffline = onoffline;
        this.needPeople = needPeople;
        this.details = details;
    }
}
