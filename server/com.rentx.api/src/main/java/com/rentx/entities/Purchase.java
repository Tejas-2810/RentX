package com.rentx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="purchase")
public class Purchase {

    @Id
    @Column(name="purchaseID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int purchaseID;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn (name="buyer_id", referencedColumnName = "userID")
    private User buyerID;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn (name="seller_id", referencedColumnName = "userID")
    private User sellerID;

    @Column(name="productID")
    private int productID;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn (name="advertisementID", referencedColumnName = "advertisement_id")
    private Advertisement advertisementID;

    @Column(name="date_of_sale")
    private LocalDateTime date_of_sale;

    @Column(name="paid")
    private double paid;

    @Column(name="is_emi")
    private int is_emi;

    public Purchase(int purchaseID, LocalDateTime date_of_sale) {
        this.purchaseID = purchaseID;
        this.date_of_sale = date_of_sale;
    }
}
