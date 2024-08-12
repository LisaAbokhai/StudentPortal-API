package com.example.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.model.student.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    
    Student findByMatricNo(Long matricNo);

    Optional<Student> findByEmail(String email);
    
}
