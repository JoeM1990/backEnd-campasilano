package com.monkilatech.backendcampasilano.model;

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
public class chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonInclude(Include.NON_EMPTY)
    String name;

    @JsonInclude(Include.NON_EMPTY)
    String lastMessage;

    @JsonInclude(Include.NON_EMPTY)
    String image;

    @JsonInclude(Include.NON_EMPTY)
    String time;

    @JsonInclude(Include.NON_EMPTY)
    boolean isActive;
}
