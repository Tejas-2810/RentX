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
@Table(name="furniture")
public class Furniture {

    @Id
    @Column(name="furnitureID")
    private int furnitureID;

    @Column(name="Furniture_Type")
    private String furnitureType;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn (name="cat_id", referencedColumnName = "category_id")
    private Category categoryID;

    @Column(name="furniture_condition")
    private String furnitureCondition;

    @Column(name="manufacturer")
    private String manufacturer;

    @Column(name="Year_of_Purchase")
    private String yearOfPurchase;


    public Furniture(String furnitureType, String manufacturer) {
        this.furnitureType = furnitureType;
        this.manufacturer = manufacturer;
    }

    public Furniture(int furnitureID, String furnitureType, String manufacturer) {
        this.furnitureID = furnitureID;
        this.furnitureType = furnitureType;
        this.manufacturer = manufacturer;
    }

}
