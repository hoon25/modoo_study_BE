package com.modoostudy.user.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="interestTB")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Interests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestID;

    @Column(nullable = false)
    private String interestName;

    @Column(nullable = false)
    private String interestClassification;

//    @OneToMany(mappedBy = "Interests")
//    private List<MappingUserInterest> userInterests = new ArrayList<>();

}
