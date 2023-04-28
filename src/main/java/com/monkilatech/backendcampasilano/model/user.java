package com.monkilatech.backendcampasilano.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "phone")
    String phone;

    @Column(name = "email")
    String email;

    @Column(name = "username")
    String username;

    @Column(name = "photo")
    String photo;

    @Column(name = "etablissement")
    int etablissement;

    @Column(name = "promotion")
    int promotion;

    @Column(name = "roles")
    String roles;

    @Column(name = "token")
    String token;
}
