package com.modoostudy.community.domain;

import javax.persistence.*;

@Entity
public class replyTB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyID;

    @ManyToOne
    @JoinColumn(name="replierID")
    private userTB userTB;

    @ManyToOne
    @JoinColumn(name="communityID")
    private communityTB communityTB;

    @Column
    private String replyContents;
    @Column
    private Long replyLike;
    @Column
    private String rTime;
}
