package com.monkilatech.backendcampasilano.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.monkilatech.backendcampasilano.model.Lessons;
import com.monkilatech.backendcampasilano.repository.LessonsRepo;
import com.monkilatech.backendcampasilano.utils.ValueException;

@Service
public class LessonsServiceImpl implements LessonsService {
    @Autowired
    private LessonsRepo lessonsRepo;

    @Override
    public List<Lessons> getAll() throws Exception {
        List<Lessons> lessons = this.lessonsRepo.findAll();

        return lessons;
    }

    @Override
    public Lessons get(long lessonsId) throws Exception {

        return this.lessonsRepo.getLessonsById(lessonsId);
    }

    @Override
    public List<Lessons> getLessonMobile(long pageNo, long pageSize) throws Exception {

        int pgNo = (int) pageNo;
        int pgSize = (int) pageSize;

        PageRequest firstPageWithTwoElements = PageRequest.of(pgNo, pgSize);

        Page<Lessons> pagedResult = lessonsRepo.findAll(firstPageWithTwoElements);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Lessons>();
        }

    }

    @Override
    public Lessons create(Lessons lessons) throws Exception {

        return this.lessonsRepo.save(lessons);
    }

    @Override
    public Lessons update(Lessons lessons) throws Exception {

        return this.lessonsRepo.save(lessons);
    }

    @Override
    public boolean delete(long lessonsId) throws Exception {

        Lessons lessons = this.lessonsRepo.getLessonsById(lessonsId);
        if (lessons == null)
            throw new ValueException("Aucune Lesson n'est trouvé avec l'id " + lessonsId);

        this.lessonsRepo.delete(lessons);

        Lessons lessonsCheckOut = this.lessonsRepo.getLessonsById(lessonsId);

        if (lessonsCheckOut != null)
            return true;
        return false;
    }
}
