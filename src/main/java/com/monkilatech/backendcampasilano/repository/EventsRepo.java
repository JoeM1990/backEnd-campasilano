package com.monkilatech.backendcampasilano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.monkilatech.backendcampasilano.model.Events;

@Repository
public interface EventsRepo extends JpaRepository<Events, Long> {

    @Query("FROM events s WHERE s.id=:eventsId")
    public Events getEtablissementById(@Param("eventsId") long eventsId);

}
