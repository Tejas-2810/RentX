package com.rentx.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name="wishlist")
public class Wishlist{

    @Id
    @Column(name="wishlistID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlistID;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn (name="userID", referencedColumnName = "userID")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn (name="productID", referencedColumnName = "productID")
    private ProductReal product;

}
