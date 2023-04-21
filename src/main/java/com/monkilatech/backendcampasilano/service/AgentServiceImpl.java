package com.monkilatech.backendcampasilano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monkilatech.backendcampasilano.model.Agents;
import com.monkilatech.backendcampasilano.repository.AgentsRepo;
import com.monkilatech.backendcampasilano.utils.ValueException;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentsRepo agentsRepo;

    @Override
    public List<Agents> getAll() throws Exception {
        List<Agents> agents = this.agentsRepo.findAll();

        return agents;
    }

    @Override
    public Agents get(long agentId) throws Exception {

        return this.agentsRepo.getAgentById(agentId);
    }

    @Override
    public Agents create(Agents agents) throws Exception {

        return this.agentsRepo.save(agents);
    }

    @Override
    public Agents update(Agents agents) throws Exception {

        return this.agentsRepo.save(agents);
    }

    @Override
    public boolean delete(long agentId) throws Exception {

        Agents agents = this.agentsRepo.getAgentById(agentId);
        if (agents == null)
            throw new ValueException("Aucun agent n'est trouvé avec l'id " + agentId);

        this.agentsRepo.delete(agents);

        Agents agentsCheckOut = this.agentsRepo.getAgentById(agentId);

        if (agentsCheckOut != null)
            return true;
        return false;
    }

}
