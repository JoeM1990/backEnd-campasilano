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

import com.monkilatech.backendcampasilano.model.Posts;
import com.monkilatech.backendcampasilano.service.PostsService;
import com.monkilatech.backendcampasilano.utils.StatusResponse;
import com.monkilatech.backendcampasilano.utils.ValueException;

@RestController
@RequestMapping("/api")
public class PostsContoller {
    @Autowired
    private PostsService postsService;

    @PostMapping("/posts")
    public ResponseEntity create(@RequestBody Posts posts) {

        StatusResponse statusResponse = new StatusResponse();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            Posts postsCreated = this.postsService.create(posts);
            if (postsCreated != null) {
                return ResponseEntity.status(HttpStatus.OK).body(postsCreated);
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
            List<Posts> posts = this.postsService.getAll();

            return ResponseEntity.status(HttpStatus.OK)
                    .body(posts);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @GetMapping("/posts/{postsId}")
    public ResponseEntity get(@PathVariable("postsId") long postsId) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            Posts posts = this.postsService.get(postsId);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(posts);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @GetMapping("/posts/mobile/posts/{pageNo}/{pageSize}")
    public ResponseEntity getPostMobile(@PathVariable("pageNo") long pageNo, @PathVariable("pageSize") long pageSize) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            List<Posts> posts = this.postsService.getPostMobile(pageNo, pageSize);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(posts);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @GetMapping("/posts/mobile/valves/{pageNo}/{pageSize}")
    public ResponseEntity getPostValves(@PathVariable("pageNo") long pageNo, @PathVariable("pageSize") long pageSize) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            List<Posts> posts = this.postsService.getPostMobile(pageNo, pageSize);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(posts);
        } catch (Exception e) {
            statusResponse.setStatus("Erreur interne");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(statusResponse);
    }

    @DeleteMapping("/posts/{postsId}")
    public ResponseEntity delete(@PathVariable("postsId") long postsId) {

        StatusResponse statusResponse = new StatusResponse();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            boolean isDeleted = this.postsService.delete(postsId);
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
