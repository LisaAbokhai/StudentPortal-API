package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.student.model.student.Student;
import com.example.student.service.ResultsService;
import com.example.student.service.TeacherService;

@RestController
@RequestMapping("/api/v1/school/teacher")

public class TeacherController {

    private final TeacherService teacherService;
    private final ResultsService resultsService;

    @Autowired
    public TeacherController(TeacherService teacherService, ResultsService resultsService) {
        this.teacherService = teacherService;
        this.resultsService = resultsService;
    }

    @GetMapping("/retrieve/students/{courseCode}")
    public List<Student> getStudentsByCourseCode(@PathVariable String courseCode) {
        return teacherService.getStudentsByCourseCode(courseCode);
    }

    @PutMapping("/update/results")
    public void updateResults(MultipartFile file, String courseCode) {
        resultsService.updateGrades(file, courseCode);
    }


    @PutMapping("/log/results")
    public void logResults(String courseCode, String comment, String teacherName, MultipartFile file) {
        resultsService.logUpload(courseCode, comment, teacherName, file);
    }

    



    
    
}
