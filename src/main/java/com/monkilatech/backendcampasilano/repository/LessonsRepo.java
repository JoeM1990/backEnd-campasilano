package com.monkilatech.backendcampasilano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.monkilatech.backendcampasilano.model.Lessons;

@Repository
public interface LessonsRepo extends JpaRepository<Lessons, Long> {
    
    @Query("FROM Lessons l WHERE l.id=:lessonsId")
    public Lessons getLessonsById(@Param("lessonsId") long lessonsId);
    
}
