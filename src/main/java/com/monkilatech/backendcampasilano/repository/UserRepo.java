package com.monkilatech.backendcampasilano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.monkilatech.backendcampasilano.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    
    @Query("FROM Users u WHERE u.id=:userId")
    public User getUserById(@Param("userId") long userId);
    
}
