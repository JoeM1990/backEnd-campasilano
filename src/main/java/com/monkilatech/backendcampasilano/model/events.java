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
@Table(name = "events")
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "content")
    String content;

    @Column(name = "cover")
    String cover;

    @Column(name = "dateOfEvent")
    Date dateOfEvent;

    @Column(name = "isPublic")
    boolean isPublic;

    @Column(name = "etablissementId")
    String etablissementId;

    @Column(name = "etablissement")
    String etablissement;

    @Column(name = "participants")
    String participants;

    @Column(name = "counts")
    int counts;

    @Column(name = "status")
    boolean status;
}
