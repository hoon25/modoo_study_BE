package com.modoostudy.community.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "replyTB")
public class replyTB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyID;

    @ManyToOne
    @JoinColumn(name="replierID")
    private userTB userTB;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name="communityID")
    private communityTB communityTB;

    @Column
    private String replyContents;
    @Column
    private Long replyLike;
    @Column
    private String rTime;
}
