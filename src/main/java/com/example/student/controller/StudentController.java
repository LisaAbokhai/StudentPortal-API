package com.example.student.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.student.DTO.ResultsDTO;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api/v1/school/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PutMapping("/update/passport")
    public ResponseEntity<?> updatePassportPhoto(
        Long matricNo,
        MultipartFile passportPhoto ) {
        
        try{
            byte[] passportPhotoBytes = passportPhoto.getBytes();


            studentService.updatePassportPhoto(
                matricNo, 
                passportPhotoBytes);
                
                return ResponseEntity.ok("Passport updated successfully");

        } catch (IOException e) { 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update photo");
        }
    }


    @PutMapping("/update/basic-info")
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

    @PutMapping("/update/documents")
    public ResponseEntity<?> updateDocuments(
        Long matricNo, 
        MultipartFile olevelResult,
        MultipartFile jambResult,
        MultipartFile referenceLetter,
        MultipartFile medicalReport,
        MultipartFile birthCertificate) {
        
        try{
            byte[] olevelResultBytes= olevelResult.getBytes();
            byte[] jambResultBytes= jambResult.getBytes();
            byte[] referenceLetterBytes= referenceLetter.getBytes();
            byte[] medicalReportBytes=   medicalReport.getBytes();
            byte[] birthCertificateBytes= birthCertificate.getBytes();

            studentService.updateDocuments(
                matricNo, 
                birthCertificateBytes, 
                jambResultBytes, 
                olevelResultBytes, 
                referenceLetterBytes, 
                medicalReportBytes);
                
                return ResponseEntity.ok("Documents updated successfully");

        } catch (IOException e) { 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update documents");
        }
    }

    @PutMapping("/update/school-info")
    public void updateSchoolInfo(Long matricNo, String school) {
        studentService.updateSchoolInfo(matricNo, school);
    }

    @PostMapping("/add/course")
    public void addCourse(Long matricNo, String courseCode) {
        studentService.addCourse(matricNo, courseCode);
    }

    @DeleteMapping("/drop/course/{matricNo}")
    public void dropCourse(@PathVariable Long matricNo, String courseCode) {
        studentService.removeCourse(matricNo, courseCode);
    }

    @GetMapping("/view/courses/{matricNo}")
    public List<String> viewCourses(@PathVariable Long matricNo) {
        return studentService.viewCourses(matricNo);
    }

    @GetMapping("/view/results/{matricNo}")
    public List<ResultsDTO> viewResults(@PathVariable Long matricNo) {
        return studentService.viewResults(matricNo);
    }

    
    
}
