package com.monkilatech.backendcampasilano.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonInclude(Include.NON_EMPTY)
    String name;

    @JsonInclude(Include.NON_EMPTY)
    String phone;

    @JsonInclude(Include.NON_EMPTY)
    String email;

    @JsonInclude(Include.NON_EMPTY)
    String username;

    @JsonInclude(Include.NON_EMPTY)
    String photo;

    @JsonInclude(Include.NON_EMPTY)
    int etablissement;

    @JsonInclude(Include.NON_EMPTY)
    int promotion;

    @JsonInclude(Include.NON_EMPTY)
    List<String> roles;

    @JsonInclude(Include.NON_EMPTY)
    String token;
}
