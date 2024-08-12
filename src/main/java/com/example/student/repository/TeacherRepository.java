package com.example.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.model.teacher.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

    Optional<Teacher> findByEmail(String email);

    Teacher findByName(String name);
}
