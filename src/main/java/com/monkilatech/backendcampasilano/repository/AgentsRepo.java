package com.monkilatech.backendcampasilano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.monkilatech.backendcampasilano.model.Agents;

@Repository
public interface AgentsRepo extends JpaRepository<Agents, Long> {

    @Query("FROM Agents a WHERE a.id=:agentId")
    public Agents getAgentById(@Param("agentId") long agentId);

}
