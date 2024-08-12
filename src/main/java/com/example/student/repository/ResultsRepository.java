package com.example.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.model.teacher.ResultId;
import com.example.student.model.teacher.Results;

@Repository
public interface ResultsRepository extends JpaRepository<Results, ResultId> {

    List<Results> findByStudentMatricNo(Long matricNo);

    List<Results> findByCourseNum(String courseNum);
    
} 
