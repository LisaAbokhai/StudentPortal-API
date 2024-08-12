package com.example.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.model.student.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, String>{
    Courses findByCourseCode(String courseCode);

    
}
