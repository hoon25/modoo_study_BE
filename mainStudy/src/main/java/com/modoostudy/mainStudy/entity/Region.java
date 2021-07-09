package com.modoostudy.mainStudy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

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
