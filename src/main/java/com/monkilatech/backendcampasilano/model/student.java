package com.monkilatech.backendcampasilano.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "uid")
    String uid;

    @Column(name = "matricule")
    String matricule;

    @Column(name = "name")
    String name;

    @Column(name = "firstname")
    String firstname;

    @Column(name = "genre")
    int genre;

    @Column(name = "phone")
    String phone;

    @Column(name = "email")
    String email;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "locationId")
    String locationId;

    @Column(name = "street")
    String street;

    @Column(name = "commonId")
    String commonId;

    @Column(name = "promotionId")
    int promotionId;

    @Column(name = "promotion")
    String promotion;

    @Column(name = "accountId")
    String accountId;

    @Column(name = "photo")
    String photo;

    @Column(name = "status")
    boolean status;

    @Column(name = "etablissementId")
    String etablissementId;

    @Column(name = "cps")
    String cps;
}
