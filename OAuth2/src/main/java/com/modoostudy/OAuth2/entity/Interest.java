package com.modoostudy.OAuth2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="interestTB")
@Getter
@NoArgsConstructor
public class Interest {

    @Id
    private Long interestID;

    @Column(nullable = false)
    private String interestName;

    @Column(nullable = false)
    private String interestClassification;


}
