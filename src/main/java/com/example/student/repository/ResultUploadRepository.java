package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.model.teacher.ResultUpload;

@Repository
public interface ResultUploadRepository extends JpaRepository<ResultUpload, Long>{
    
    
}
