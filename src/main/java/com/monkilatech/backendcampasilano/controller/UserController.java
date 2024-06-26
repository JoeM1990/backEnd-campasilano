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

import com.monkilatech.backendcampasilano.model.User;
import com.monkilatech.backendcampasilano.service.UserService;
import com.monkilatech.backendcampasilano.utils.StatusResponse;
import com.monkilatech.backendcampasilano.utils.ValueException;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity create(@RequestBody User user) {

        StatusResponse statusResponse = new StatusResponse();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            User userCreated = this.userService.create(user);
            if (userCreated != null) {
                return ResponseEntity.status(HttpStatus.OK).body(userCreated);
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
            List<User> users = this.userService.getAll();

            return ResponseEntity.status(HttpStatus.OK)
                    .body(users);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity get(@PathVariable("userId") long UserId) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            User user = this.userService.get(UserId);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(user);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity delete(@PathVariable("userId") long userId) {

        StatusResponse statusResponse = new StatusResponse();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            boolean isDeleted = this.userService.delete(userId);
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
