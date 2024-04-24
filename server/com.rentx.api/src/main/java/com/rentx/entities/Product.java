package com.rentx.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

/**
 * product entity class
 */
@Table
@Getter
@Setter
@Entity
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name="getAllAvailableProducts",procedureName = "get_available_products", resultClasses = { Product.class }),
                                @NamedStoredProcedureQuery(name = "getAllAvailableProduct", procedureName = "get_available_product", resultClasses = { Product.class }, parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "sp_product_id", type = Integer.class)})})
public class Product implements Serializable {

    private int advertisement_id;

    private String advt_title;

    private Date post_date;

    private Date expiry_date;

    private String userID;

    private String phone;

    private String first_name;

    private String last_name;

    private String pref_language;

    private Date joining_date;

    private String privacy;

    private String status;

    private String email;

    @Id
    private int productID;

    private String product_name;

    private String product_description;

    private float Price;

    private int category_id;

    private String category_name;

    private int areaID;

    private String area_name;

    private String city;

    private String state;

    private String country;
}
