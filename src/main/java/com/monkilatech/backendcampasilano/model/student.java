package com.monkilatech.backendcampasilano.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonInclude(Include.NON_EMPTY)
    String uid;

    @JsonInclude(Include.NON_EMPTY)
    String matricule;

    @JsonInclude(Include.NON_EMPTY)
    String name;

    @JsonInclude(Include.NON_EMPTY)
    String firstname;

    @JsonInclude(Include.NON_EMPTY)
    int genre;

    @JsonInclude(Include.NON_EMPTY)
    String phone;

    @JsonInclude(Include.NON_EMPTY)
    String email;

    @JsonInclude(Include.NON_EMPTY)
    String username;

    @JsonInclude(Include.NON_EMPTY)
    String password;

    @JsonInclude(Include.NON_EMPTY)
    String locationId;

    @JsonInclude(Include.NON_EMPTY)
    String street;

    @JsonInclude(Include.NON_EMPTY)
    String commonId;

    @JsonInclude(Include.NON_EMPTY)
    int promotionId;

    @JsonInclude(Include.NON_EMPTY)
    String promotion;

    @JsonInclude(Include.NON_EMPTY)
    String accountId;

    @JsonInclude(Include.NON_EMPTY)
    String photo;

    @JsonInclude(Include.NON_EMPTY)
    boolean status;

    @JsonInclude(Include.NON_EMPTY)
    String etablissementId;

    @JsonInclude(Include.NON_EMPTY)
    String cps;
}
