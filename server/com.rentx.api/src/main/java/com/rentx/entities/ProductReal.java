package com.rentx.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name = "product")
public class ProductReal {
    @Id
    @Column(name = "productID")
    private int productID;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;

    @Column(name = "sellType")
    private String sellType;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "areaID")
    private Area area;

    // For electronic gadgets
    @Transient
    private String manufacture; // Same for Furniture and Kitchen Appliances
    @Transient
    private String year_of_purchase; // Same for Furniture and Kitchen Appliances
    @Transient
    private String model_name; // Same for Kitchen Appliances
    @Transient
    private String gadget_type;

    // For Furniture
    @Transient
    private String furniture_type;
    @Transient
    private String condition;

    // For Books
    @Transient
    private String author;
    @Transient
    private String year_of_public;

    // For Kitchen Appliances
    @Transient
    private String appliance_type;

    // For advertisement
    @Transient
    private String verificationStatus;
    @Transient
    private String advtTitle;
    @Transient
    private String isActive;
    @Transient
    private Date postDate;
    @Transient
    private Date expiryDate;
}
