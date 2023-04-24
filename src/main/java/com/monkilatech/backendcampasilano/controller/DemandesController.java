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

import com.monkilatech.backendcampasilano.model.Demandes;
import com.monkilatech.backendcampasilano.service.DemandeService;
import com.monkilatech.backendcampasilano.utils.StatusResponse;
import com.monkilatech.backendcampasilano.utils.ValueException;

@RestController
@RequestMapping("/api")
public class DemandesController {

    @Autowired
    private DemandeService demandeService;

    @PostMapping("/demandes")
    public ResponseEntity create(@RequestBody Demandes demandes) {

        StatusResponse statusResponse = new StatusResponse();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            Demandes demandeCreated = this.demandeService.create(demandes);
            if (demandeCreated != null) {
                return ResponseEntity.status(HttpStatus.OK).body(demandeCreated);
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
            List<Demandes> demandes = this.demandeService.getAll();

            return ResponseEntity.status(HttpStatus.OK)
                    .body(demandes);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @GetMapping("/demandes/{demandeId}")
    public ResponseEntity get(@PathVariable("demandeId") long demandeId) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            Demandes demandes = this.demandeService.get(demandeId);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(demandes);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @DeleteMapping("/demandes/{demandeId}")
    public ResponseEntity delete(@PathVariable("demandeId") long demandeId) {

        StatusResponse statusResponse = new StatusResponse();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            boolean isDeleted = this.demandeService.delete(demandeId);
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
