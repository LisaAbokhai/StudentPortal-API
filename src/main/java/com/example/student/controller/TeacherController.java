package com.example.student.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    public List<String> getStudentsByCourseCode(@PathVariable String courseCode) {
        return teacherService.getStudentsByCourseCode(courseCode);
    }

    @PutMapping("/update/results")
    public void updateResults(MultipartFile file, String courseCode) {
        resultsService.updateGrades(file, courseCode);
    }


    @PostMapping("/log/results-repo")
    public void logResults(String courseCode, String comment, String teacherName, MultipartFile file) throws IOException {
        resultsService.logUpload(courseCode, comment, teacherName, file);
    } //change to postmapping

    



    
    
}
