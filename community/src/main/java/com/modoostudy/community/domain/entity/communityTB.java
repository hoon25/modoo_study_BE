package com.modoostudy.community.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "communityTB")
@Getter
@Setter
public class communityTB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long communityID;

    @ManyToOne
    @JoinColumn(name="writerID")
    @JsonManagedReference
    private userTB userTB;

    @Column
    private String textTitle;

    @Column
    private String wTime;

    @Column
    private String textContents;

    @Column
    private String contentImage;

    @Column
    private Long likeCount;

    @Column
    private String category;
}
