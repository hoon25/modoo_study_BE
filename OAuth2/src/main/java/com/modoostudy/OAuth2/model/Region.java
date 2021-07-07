package com.modoostudy.OAuth2.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="regionTB")
@Getter
@NoArgsConstructor
public class Region {

    @Id
    private String regionName;

}
