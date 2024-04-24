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
@Table(name="kitchen_appliances")
public class KitchenAppliance {

    @Id
    @Column(name="kitchen_appliances_id")
    private int kitchenApplianceID;

    @Column(name="manufacturer")
    private String manufacturer;

    
    @Column(name="year_of_purchase")
    private String yearOfPurchase;
    
    @Column(name="model_name")
    private String modelName;
    
    @Column(name="appliance_type")
    private String applianceType;
    
    @ManyToOne
    @JoinColumn(name="cat_id")
    private Category categoryID;


    public KitchenAppliance(int i, String ikea, String number, String s, String sofa) {
    }
}
