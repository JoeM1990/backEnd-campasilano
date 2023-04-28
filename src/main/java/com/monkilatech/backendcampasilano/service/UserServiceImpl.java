package com.monkilatech.backendcampasilano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monkilatech.backendcampasilano.model.User;
import com.monkilatech.backendcampasilano.repository.UserRepo;
import com.monkilatech.backendcampasilano.utils.ValueException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAll() throws Exception {
        List<User> users = this.userRepo.findAll();

        return users;
    }

    @Override
    public User get(long userId) throws Exception {

        return this.userRepo.getUserById(userId);
    }

    @Override
    public User create(User user) throws Exception {

        return this.userRepo.save(user);
    }

    @Override
    public User update(User user) throws Exception {

        return this.userRepo.save(user);
    }

    @Override
    public boolean delete(long userId) throws Exception {

        User user = this.userRepo.getUserById(userId);
        if (user == null)
            throw new ValueException("Aucun User n'est trouvé avec l'id " + userId);

        this.userRepo.delete(user);

        User userCheckOut = this.userRepo.getUserById(userId);

        if (userCheckOut != null)
            return true;
        return false;
    }
}
