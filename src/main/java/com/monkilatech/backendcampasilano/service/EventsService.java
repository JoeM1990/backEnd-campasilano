package com.monkilatech.backendcampasilano.service;

import java.util.List;

import com.monkilatech.backendcampasilano.model.Events;

public interface EventsService {
    public List<Events> getAll() throws Exception;

    public Events get(long agentId) throws Exception;

    public List<Events> getEventMobile(long pageNo, long pageSize) throws Exception;

    public Events create(Events Events) throws Exception;

    public Events update(Events Events) throws Exception;

    public boolean delete(long agentId) throws Exception;
}
