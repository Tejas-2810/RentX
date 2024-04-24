package com.rentx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="area")
public class Area {
    @Id
    @Column(name="areaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int areaID;

    @Column(name = "area_name")
    private String areaName;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;
}
