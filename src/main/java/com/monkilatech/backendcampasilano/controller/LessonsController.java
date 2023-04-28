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

import com.monkilatech.backendcampasilano.model.Lessons;
import com.monkilatech.backendcampasilano.service.LessonsService;
import com.monkilatech.backendcampasilano.utils.StatusResponse;
import com.monkilatech.backendcampasilano.utils.ValueException;

@RestController
@RequestMapping("/api")
public class LessonsController {
    @Autowired
    private LessonsService lessonsService;

    @PostMapping("/lessons")
    public ResponseEntity create(@RequestBody Lessons lessons) {

        StatusResponse statusResponse = new StatusResponse();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            Lessons lessonsCreated = this.lessonsService.create(lessons);
            if (lessonsCreated != null) {
                return ResponseEntity.status(HttpStatus.OK).body(lessonsCreated);
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
            List<Lessons> lessons = this.lessonsService.getAll();

            return ResponseEntity.status(HttpStatus.OK)
                    .body(lessons);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @GetMapping("/lessons/{lessonsId}")
    public ResponseEntity get(@PathVariable("lessonsId") long lessonsId) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            Lessons Lessons = this.lessonsService.get(lessonsId);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(Lessons);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @DeleteMapping("/lessons/{lessonsId}")
    public ResponseEntity delete(@PathVariable("lessonsId") long lessonsId) {

        StatusResponse statusResponse = new StatusResponse();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            boolean isDeleted = this.lessonsService.delete(lessonsId);
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
