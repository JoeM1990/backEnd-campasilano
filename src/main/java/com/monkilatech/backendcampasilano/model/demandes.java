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
@Table(name = "demandes")
public class Demandes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "fromUid")
    String fromUid;

    @Column(name = "senderUid")
    String senderUid;

    @Column(name = "sender")
    String sender;

    @Column(name = "photo")
    String photo;

    @Column(name = "promotion")
    String promotion;

    @Column(name = "content")
    String content;

    @Column(name = "dateCreation")
    Date dateCreation;
}
