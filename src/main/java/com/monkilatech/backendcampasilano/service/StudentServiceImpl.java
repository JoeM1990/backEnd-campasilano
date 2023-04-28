package com.monkilatech.backendcampasilano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monkilatech.backendcampasilano.model.Student;
import com.monkilatech.backendcampasilano.repository.StudentRepo;
import com.monkilatech.backendcampasilano.utils.ValueException;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAll() throws Exception {
        List<Student> students = this.studentRepo.findAll();

        return students;
    }

    @Override
    public Student get(long studentId) throws Exception {

        return this.studentRepo.getStudentById(studentId);
    }

    @Override
    public Student create(Student student) throws Exception {

        return this.studentRepo.save(student);
    }

    @Override
    public Student update(Student student) throws Exception {

        return this.studentRepo.save(student);
    }

    @Override
    public boolean delete(long studentId) throws Exception {

        Student student = this.studentRepo.getStudentById(studentId);
        if (student == null)
            throw new ValueException("Aucun Student n'est trouvé avec l'id " + studentId);

        this.studentRepo.delete(student);

        Student studentCheckOut = this.studentRepo.getStudentById(studentId);

        if (studentCheckOut != null)
            return true;
        return false;
    }
}
