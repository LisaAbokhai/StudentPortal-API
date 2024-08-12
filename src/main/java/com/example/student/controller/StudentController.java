package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.student.Courses;
import com.example.student.model.teacher.Results;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api/v1/school/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/update/passport") 
    public void updatePassportPhoto(Long matricNo, byte[] passportPhoto) {
        studentService.updatePassportPhoto(matricNo, passportPhoto);
    }

    @PostMapping("/update/basic-info")
    public void updateBasicInfo(
        Long matricNo, 
        String nextofkin, 
        String kinphoneNo, 
        String kinAdress, 
        String sponsor, 
        String sponsorPhoneNo, 
        String sponsorAddress) {
        studentService.updateBasicInfo(
            matricNo, 
            nextofkin, 
            kinphoneNo, 
            kinAdress, 
            sponsor, 
            sponsorPhoneNo, 
            sponsorAddress);
    }

    @PostMapping("/update/documents")
    public void updateDocuments(
        Long matricNo, 
        byte[] olevelResult,
        byte[] jambResult,
        byte[] jambAdmission,
        byte[] referenceLetter,
        byte[] originCertificate,
        byte[] testimonal,
        byte[] medicalReport,
        byte[] birthCertificate,
        byte[] admissionLetter) {

        studentService.updateDocuments(
            matricNo, 
            birthCertificate, 
            admissionLetter, 
            jambAdmission, 
            jambResult, 
            olevelResult, 
            referenceLetter, 
            originCertificate, 
            testimonal, 
            medicalReport);
    }

    @PostMapping("/update/school-info")
    public void updateSchoolInfo(Long matricNo, String School) {
        studentService.updateSchoolInfo(matricNo, School);
    }

    @PostMapping("/add/course")
    public void addCourse(Long matricNo, String courseCode) {
        studentService.addCourse(matricNo, courseCode);
    }

    @PostMapping("/drop/course/{matricNo}")
    public void dropCourse(@PathVariable Long matricNo, String courseCode) {
        studentService.removeCourse(matricNo, courseCode);
    }

    @GetMapping("/view/courses/{matricNo}")
    public List<Courses> viewCourses(@PathVariable Long matricNo) {
        return studentService.viewCourses(matricNo);
    }

    @GetMapping("/view/results/{matricNo}")
    public List<Results> viewResults(@PathVariable Long matricNo) {
        return studentService.viewResults(matricNo);
    }





    
    
}
