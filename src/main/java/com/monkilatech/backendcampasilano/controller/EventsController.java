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

import com.monkilatech.backendcampasilano.model.Events;
import com.monkilatech.backendcampasilano.service.EventsService;
import com.monkilatech.backendcampasilano.utils.StatusResponse;
import com.monkilatech.backendcampasilano.utils.ValueException;

@RestController
@RequestMapping("/api")
public class EventsController {
    @Autowired
    private EventsService eventsService;

    @PostMapping("/events")
    public ResponseEntity create(@RequestBody Events events) {

        StatusResponse statusResponse = new StatusResponse();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            Events eventsCreated = this.eventsService.create(events);
            if (eventsCreated != null) {
                return ResponseEntity.status(HttpStatus.OK).body(eventsCreated);
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
            List<Events> events = this.eventsService.getAll();

            return ResponseEntity.status(HttpStatus.OK)
                    .body(events);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @GetMapping("/events/{eventsId}")
    public ResponseEntity get(@PathVariable("eventsId") long eventsId) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            Events events = this.eventsService.get(eventsId);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(events);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @GetMapping("/event/mobile/participer/{eventsId}")
    public ResponseEntity participerEvent(@PathVariable("eventsId") long eventsId) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            Events events = this.eventsService.get(eventsId);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(events);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @GetMapping("/event/mobile/events/{pageNo}/{pageSize}")
    public ResponseEntity getPostValves(@PathVariable("pageNo") long pageNo, @PathVariable("pageSize") long pageSize) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            List<Events> Posts = this.eventsService.getEventMobile(pageNo, pageSize);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(Posts);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @DeleteMapping("/events/{eventsId}")
    public ResponseEntity delete(@PathVariable("eventsId") long eventsId) {

        StatusResponse statusResponse = new StatusResponse();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            boolean isDeleted = this.eventsService.delete(eventsId);
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
