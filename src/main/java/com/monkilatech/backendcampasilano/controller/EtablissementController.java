package com.monkilatech.backendcampasilano.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monkilatech.backendcampasilano.model.Etablissement;
import com.monkilatech.backendcampasilano.service.EtablissementService;
import com.monkilatech.backendcampasilano.utils.StatusResponse;
import com.monkilatech.backendcampasilano.utils.ValueException;

@RestController
@RequestMapping("/api")
public class EtablissementController {
    @Autowired
    private EtablissementService etablissementService;

    @PostMapping("/etablissement")
    public ResponseEntity create(@RequestBody Etablissement etablissement) {

        StatusResponse statusResponse = new StatusResponse();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            Etablissement etablissementCreated = this.etablissementService.create(etablissement);
            if (etablissementCreated != null) {
                return ResponseEntity.status(HttpStatus.OK).body(etablissementCreated);
            } else
                statusResponse.setMessage("Echec d'enregistrement");

        } catch (ValueException e) {
            statusResponse.setMessage(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            statusResponse.setMessage("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(httpStatus).body(statusResponse);
    }

    @GetMapping
    public ResponseEntity getAll() {
        StatusResponse statusResponse = new StatusResponse();
        try {
            List<Etablissement> etablissements = this.etablissementService.getAll();

            return ResponseEntity.status(HttpStatus.OK)
                    .body(etablissements);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @GetMapping("/etablissement/{etablissementId}")
    public ResponseEntity get(@PathVariable("etablissementId") long etablissementId) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            Etablissement etablissement = this.etablissementService.get(etablissementId);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(etablissement);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @DeleteMapping("/etablissement/{etablissementId}")
    public ResponseEntity delete(@PathVariable("etablissementId") long etablissementId) {

        StatusResponse statusResponse = new StatusResponse();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            boolean isDeleted = this.etablissementService.delete(etablissementId);
            if (isDeleted) {
                statusResponse.setStatus(HttpStatus.OK.name());
                return ResponseEntity.status(HttpStatus.OK).body(statusResponse);
            } else
                statusResponse.setMessage("Echec de suppression");

        } catch (ValueException e) {
            statusResponse.setMessage(e.getMessage());
        } catch (Exception e) {
            statusResponse.setMessage("Erreur interne");
        }
        return ResponseEntity.status(httpStatus).body(statusResponse);
    }

}
