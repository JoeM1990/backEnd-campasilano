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
@Table(name = "lessons")
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "content")
    String content;

    @Column(name = "url")
    String url;

    @Column(name = "type")
    int type;

    @Column(name = "extension")
    String extension;

    @Column(name = "uidAgent")
    String uidAgent;

    @Column(name = "photo")
    String photo;

    @Column(name = "promotionId")
    int promotionId;

    @Column(name = "promotion")
    String promotion;

    @Column(name = "dateCreation")
    Date dateCreation;

}
