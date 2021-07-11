package com.modoostudy.user.domain;

import lombok.Builder;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long muiID;

    @ManyToOne
    @JoinColumn(name="userID")
    private User user;

    @ManyToOne
    @JoinColumn(name="interestID")
    private Interests Interests;

    @Builder
    public MappingUserInterest(User user, Interests Interests) {
        this.user = user;
        this.Interests = Interests;
    }
}
