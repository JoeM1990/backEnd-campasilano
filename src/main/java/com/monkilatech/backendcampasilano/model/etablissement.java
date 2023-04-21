package com.monkilatech.backendcampasilano.model;

import java.util.Date;

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
public class Etablissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonInclude(Include.NON_EMPTY)
    String sigleName;

    @JsonInclude(Include.NON_EMPTY)
    String name;

    @JsonInclude(Include.NON_EMPTY)
    String logo;

    @JsonInclude(Include.NON_EMPTY)
    boolean status;

    @JsonInclude(Include.NON_EMPTY)
    Date dateCreation;

    @JsonInclude(Include.NON_EMPTY)
    int access;
}
