package com.monkilatech.backendcampasilano.service;

import java.util.List;

import com.monkilatech.backendcampasilano.model.User;

public interface UserService {
    
    public List<User> getAll() throws Exception;

    public User get(long userId) throws Exception;

    public User create(User user) throws Exception;

    public User update(User user) throws Exception;

    public boolean delete(long userId) throws Exception;
    
}
