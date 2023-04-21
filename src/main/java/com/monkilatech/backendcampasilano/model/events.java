package com.monkilatech.backendcampasilano.model;

import java.util.Date;
import java.util.List;

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
public class Events {

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
    Date dateOfEvent;

    @JsonInclude(Include.NON_EMPTY)
    boolean isPublic;

    @JsonInclude(Include.NON_EMPTY)
    String etablissementId;

    @JsonInclude(Include.NON_EMPTY)
    String etablissement;

    @JsonInclude(Include.NON_EMPTY)
    List<String> participants;

    @JsonInclude(Include.NON_EMPTY)
    int counts;

    @JsonInclude(Include.NON_EMPTY)
    boolean status;
}
