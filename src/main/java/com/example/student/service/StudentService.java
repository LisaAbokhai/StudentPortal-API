package com.example.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.student.Courses;
import com.example.student.model.student.Student;
import com.example.student.model.teacher.ResultId;
import com.example.student.model.teacher.Results;
import com.example.student.repository.ResultsRepository;
import com.example.student.repository.StudentRepository;
import com.example.student.repository.CoursesRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ResultsRepository resultsRepository;
    private final CoursesRepository courseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, ResultsRepository resultsRepository, CoursesRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.resultsRepository = resultsRepository;
        this.courseRepository = courseRepository;

    }
    

    public void updatePassportPhoto(Long matricNo, byte[] passportPhoto) {
        Student student = studentRepository.findByMatricNo(matricNo);
        student.setPassport(passportPhoto);
        studentRepository.save(student);

    }

    public void updateBasicInfo(Long matricNo, 
                                String nextofkin, 
                                String kinphoneNo, 
                                String kinAdress, 
                                String sponsor, 
                                String sponsorPhoneNo, 
                                String sponsorAddress) {
        Student student = studentRepository.findByMatricNo(matricNo);
        student.setNextOfKin(nextofkin);
        student.setKinPhoneNumber(kinphoneNo);
        student.setKinAddress(kinAdress);
        student.setSponsor(sponsor);
        student.setSponsorPhoneNumber(sponsorPhoneNo);
        student.setSponsorAddress(sponsorAddress);
        studentRepository.save(student);

    }   
    
    public void updateDocuments (Long matricNo, 
                                    byte[] olevelResult,
                                    byte[] jambResult,
                                    byte[] jambAdmission,
                                    byte[] referenceLetter,
                                    byte[] originCertificate,
                                    byte[] testimonal,
                                    byte[] medicalReport,
                                    byte[] birthCertificate,
                                    byte[] admissionLetter
                                    ) {
        Student student = studentRepository.findByMatricNo(matricNo);
        student.setOLevel(olevelResult);
        student.setJambResult(jambResult);
        student.setJambAdmission(jambAdmission);
        student.setReferenceLetter(referenceLetter);
        student.setOriginCertificate(originCertificate);
        student.setTestimonal(testimonal);
        student.setAdmissionLetter(admissionLetter);
        student.setBirthCertificate(birthCertificate);
        student.setMedicalReport(medicalReport);
        studentRepository.save(student);
    }

    public void updateSchoolInfo(Long matricNo, String school) {
        Student student = studentRepository.findByMatricNo(matricNo);
        student.setSchool(school);
        studentRepository.save(student);
    }


    public void addCourse(Long matricNo, String courseCode) {
        ResultId resultId = new ResultId(matricNo, courseCode);
    
        Results result = resultsRepository.findById(resultId).orElse(new Results());
        result.setId(resultId);
        
        Student student = studentRepository.findById(matricNo).orElse(null); // Fetch student by matricNo
        Courses course = courseRepository.findById(courseCode).orElse(null); // Fetch course by courseCode
    
        result.setStudent(student);
        result.setCourse(course);
        
        result.setGrade(0); // Initialize grade to 0
    
        resultsRepository.save(result);
    }

    public void removeCourse(Long matricNo, String courseCode) {
        ResultId resultId = new ResultId();
        resultId.setMatricNo(matricNo);
        resultId.setCourseCode(courseCode);

        resultsRepository.deleteById(resultId);
    }

    public List<Courses> viewCourses(Long matricNo) {
        List<Results> results = resultsRepository.findByStudentMatricNo(matricNo);
        List<Courses> courses = new ArrayList<>();
        for (Results result : results) {
            courses.add(result.getCourse());
        }
        return courses;
        
    }

    public List<Results> viewResults(Long matricNo) {
        return resultsRepository.findByStudentMatricNo(matricNo);
    }

}
