package com.monkilatech.backendcampasilano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.monkilatech.backendcampasilano.model.Agents;

public interface AgentsRepo extends JpaRepository<Agents, Long> {

    @Query("FROM Agents s WHERE s.id=:agentId")
    public Agents getAgentById(@Param("agentId") long agentId);

}
