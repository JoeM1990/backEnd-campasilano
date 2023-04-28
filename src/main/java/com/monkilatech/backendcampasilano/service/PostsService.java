package com.monkilatech.backendcampasilano.service;

import java.util.List;

import com.monkilatech.backendcampasilano.model.Posts;

public interface PostsService {
    public List<Posts> getAll() throws Exception;

    public Posts get(long postsId) throws Exception;

    public Posts create(Posts Lessons) throws Exception;

    public Posts update(Posts Lessons) throws Exception;

    public boolean delete(long postsId) throws Exception;
}
