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
@Table(name="electronic_gadgets")
public class ElectronicGadget {

    @Id
    @Column(name="electronic_id")
    private int electronicGadgetsID;

    @Column(name="manufacturer")
    private String manufacturer;

    
    @Column(name="year_of_purchase")
    private String yearOfPurchase;
    
    @Column(name="model_name")
    private String modelName;
    
    @Column(name="Gadget_Type")
    private String gadgetType;
    
    @ManyToOne
    @JoinColumn(name="cat_id")
    private Category categoryID;


    public ElectronicGadget(int electronicGadgetsID, String manufacturer, String yearOfPurchase, String modelName, String gadgetType) {
    }
}
