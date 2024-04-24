package com.rentx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="advertisement")
public class Advertisement {

    @Id
    @Column(name="advertisement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int advertisementID;

    @Column(name = "verification_status")
    private String verificationStatus;

    @Column(name = "advt_title")
    private String advtTitle;

    @Column(name = "is_active")
    private String isActive;

    @Column(name = "post_date")
    private Date postDate;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn (name="user_id", referencedColumnName = "userID")
    private User userID;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn (name="product_id", referencedColumnName = "productID")
    private ProductReal productID;
}
