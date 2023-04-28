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
@Table(name = "etablissement")
public class Etablissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "sigkleName")
    String sigleName;

    @Column(name = "name")
    String name;

    @Column(name = "logo")
    String logo;

    @Column(name = "status")
    boolean status;

    @Column(name = "dateCreation")
    Date dateCreation;

    @Column(name = "access")
    int access;
}
