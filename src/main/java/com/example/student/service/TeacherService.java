package com.example.student.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.student.Student;
import com.example.student.repository.ResultsRepository;
import com.example.student.repository.StudentRepository;

@Service
public class TeacherService {

    private final StudentRepository studentRepository;
    private final ResultsRepository resultsRepository;

    @Autowired
    public TeacherService(StudentRepository studentRepository, ResultsRepository resultsRepository) {
        this.studentRepository = studentRepository;
        this.resultsRepository = resultsRepository;
    }

    public List<Student> getStudentsByCourseCode(String courseCode) {
        List<Long> matricNo = resultsRepository.findByCourseNum(courseCode)
                                                    .stream()
                                                    .map(result -> result.getId().getMatricNo())
                                                    .distinct()
                                                    .collect(Collectors.toList());

        return studentRepository.findAllById(matricNo);
    }

    

    
}
