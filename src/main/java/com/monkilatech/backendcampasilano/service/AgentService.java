package com.monkilatech.backendcampasilano.service;

import java.util.List;

import com.monkilatech.backendcampasilano.model.Agents;

public interface AgentService {

    public List<Agents> getAll() throws Exception;

    public Agents get(long agentId) throws Exception;

    public Agents create(Agents agents) throws Exception;

    public Agents update(Agents agents) throws Exception;

    public boolean delete(long agentId) throws Exception;
}
