package com.monkilatech.backendcampasilano.service;

import java.util.List;

import com.monkilatech.backendcampasilano.model.Student;

public interface StudentService {
    public List<Student> getAll() throws Exception;

    public Student get(long studentId) throws Exception;

    public Student create(Student student) throws Exception;

    public Student update(Student student) throws Exception;

    public boolean delete(long studentId) throws Exception;
}
