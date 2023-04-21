package com.monkilatech.backendcampasilano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monkilatech.backendcampasilano.model.Agents;
import com.monkilatech.backendcampasilano.service.AgentService;
import com.monkilatech.backendcampasilano.utils.StatusResponse;
import com.monkilatech.backendcampasilano.utils.ValueException;

@RestController
public class AgentsController {

    @Autowired
    private AgentService agentService;

    @PostMapping("/agents")
    public ResponseEntity create(@RequestBody Agents agents) {

        StatusResponse statusResponse = new StatusResponse();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            Agents agentCreated = this.agentService.create(agents);
            if (agentCreated != null) {
                return ResponseEntity.status(HttpStatus.OK).body(agentCreated);
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

}
