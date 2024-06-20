package com.monkilatech.backendcampasilano.service;

import java.util.List;

import com.monkilatech.backendcampasilano.model.Lessons;

public interface LessonsService {
    
    public List<Lessons> getAll() throws Exception;

    public Lessons get(long lessonsId) throws Exception;

    public List<Lessons> getLessonMobile(long pageNo, long pageSize) throws Exception;

    public Lessons create(Lessons Lessons) throws Exception;

    public Lessons update(Lessons Lessons) throws Exception;

    public boolean delete(long lessonsId) throws Exception;
    
}
