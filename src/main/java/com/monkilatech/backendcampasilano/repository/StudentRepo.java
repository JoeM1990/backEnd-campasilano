package com.monkilatech.backendcampasilano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.monkilatech.backendcampasilano.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    
    @Query("FROM Student s WHERE s.id=:studentId")
    public Student getStudentById(@Param("studentId") long studentId);
    
}
