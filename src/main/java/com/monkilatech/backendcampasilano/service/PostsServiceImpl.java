package com.monkilatech.backendcampasilano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monkilatech.backendcampasilano.model.Posts;
import com.monkilatech.backendcampasilano.repository.PostsRepo;
import com.monkilatech.backendcampasilano.utils.ValueException;

@Service
public class PostsServiceImpl implements PostsService {
    @Autowired
    private PostsRepo postsRepo;

    @Override
    public List<Posts> getAll() throws Exception {
        List<Posts> posts = this.postsRepo.findAll();

        return posts;
    }

    @Override
    public Posts get(long postsId) throws Exception {

        return this.postsRepo.getPostById(postsId);
    }

    @Override
    public Posts create(Posts posts) throws Exception {

        return this.postsRepo.save(posts);
    }

    @Override
    public Posts update(Posts Posts) throws Exception {

        return this.postsRepo.save(Posts);
    }

    @Override
    public boolean delete(long postsId) throws Exception {

        Posts posts = this.postsRepo.getPostById(postsId);
        if (posts == null)
            throw new ValueException("Aucun Posts n'est trouvé avec l'id " + postsId);

        this.postsRepo.delete(posts);

        Posts postsCheckOut = this.postsRepo.getPostById(postsId);

        if (postsCheckOut != null)
            return true;
        return false;
    }
}
