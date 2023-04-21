package com.monkilatech.backendcampasilano.model;

import java.util.Date;

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
public class posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonInclude(Include.NON_EMPTY)
    String name;

    @JsonInclude(Include.NON_EMPTY)
    String description;

    @JsonInclude(Include.NON_EMPTY)
    String content;

    @JsonInclude(Include.NON_EMPTY)
    String cover;

    @JsonInclude(Include.NON_EMPTY)
    String uidAgent;

    @JsonInclude(Include.NON_EMPTY)
    String photo;

    @JsonInclude(Include.NON_EMPTY)
    Date dateCreation;
}
