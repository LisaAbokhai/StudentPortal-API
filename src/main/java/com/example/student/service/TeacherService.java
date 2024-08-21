package com.example.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.student.Student;
import com.example.student.model.teacher.Results;
import com.example.student.repository.ResultsRepository;

@Service
public class TeacherService {

    private final ResultsRepository resultsRepository;

    @Autowired
    public TeacherService( ResultsRepository resultsRepository) {
        this.resultsRepository = resultsRepository;
    }

    public List<String> getStudentsByCourseCode(String courseCode) {

        List<Results> results = resultsRepository.findByCourse_CourseCode(courseCode);
        List<String> studentNames = new ArrayList<>();
        for (Results result : results) {
            Student student = result.getStudent(); // Get the Student object from the result
            if (student != null) {
                studentNames.add(student.getFirstName() + " " + student.getMiddleName() + " " + student.getSurname() + " -" + student.getMatricNo()); 
            }
        }

        return studentNames;

    }


    

    
}
