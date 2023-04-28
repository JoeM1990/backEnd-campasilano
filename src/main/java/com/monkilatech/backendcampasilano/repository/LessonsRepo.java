package com.monkilatech.backendcampasilano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.monkilatech.backendcampasilano.model.Lessons;

public interface LessonsRepo extends JpaRepository<Lessons, Long> {
    @Query("FROM lessons s WHERE s.id=:lessonsId")
    public Lessons getLessonsById(@Param("lessonsId") long lessonsId);
}
