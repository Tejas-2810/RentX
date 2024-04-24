package com.rentx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * user entity class
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="userID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @Column(name = "phone")
    private String phone;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "pref_language")
    private String prefLanguage;

    @Column(name = "joining_date")
    private Date joiningDate;

    @Column(name = "privacy")
    private String privacy;

    @Column(name = "status")
    private String status;

    @Column(name = "area_ID")
    private int areaId;

    @Column(name = "login")
    private String login;

    @Column(name = "token")
    private String password;

    @Column(name = "reset_token")
    private String resetToken;

    @Column(name = "email")
    private String email;

    @Column(name = "isexists")
    private int isExists;
}
