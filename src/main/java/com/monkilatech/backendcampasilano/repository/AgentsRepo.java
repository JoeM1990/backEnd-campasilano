package com.monkilatech.backendcampasilano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monkilatech.backendcampasilano.model.Agents;

@Repository
public interface AgentsRepo extends JpaRepository<Agents, Long> {

}
