package com.monkilatech.backendcampasilano.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String uid;

    String matricule;

    String name;

    String firstname;

    int genre;

    String phone;

    String email;

    String username;

    String password;

    String roles;

    boolean status;

    String locationId;

    int fonctionId;

    String fonction;

    int promotionId;

    String promotion;

    String etablissementId;

    String street;

    String commonId;

    String photo;
}
