package com.example.student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.student.model.admin.Admin;
import com.example.student.model.student.Courses;
import com.example.student.model.student.Student;
import com.example.student.model.teacher.Teacher;
import com.example.student.service.AdminService;

@RestController
@RequestMapping("/api/v1/school/admin")
public class AdminController {

    
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create/admin")
    public ResponseEntity<Admin> createAdmin(@RequestParam String name, @RequestParam String email) {
        Admin newAdmin = adminService.createAdmin(name, email);
        return ResponseEntity.ok(newAdmin);
        
    }

    @PostMapping("/create/teacher")
    public ResponseEntity<Teacher> createTeacher(@RequestParam String name, @RequestParam String email) {
        Teacher newTeacher = adminService.createTeacher(name, email);
        return ResponseEntity.ok(newTeacher);
    }

    @PostMapping("/create/student")
    public ResponseEntity<Student> createStudent(@RequestParam Long admissionNo) {
        Student newStudent = adminService.createStudent(admissionNo);
        return ResponseEntity.ok(newStudent);
    }

    @PostMapping("/create/courses")
    public void createCourses(@RequestParam  MultipartFile file) {
        adminService.uploadCourses(file);
    }

    @GetMapping("/view/teachers")
    public List<Teacher> getTeachers() {
        return adminService.getTeachers();
    }

    @GetMapping("/view/students")
    public List<Student> getStudents() {
        return adminService.getStudents();
    }

    @GetMapping("/view/courses")
    public List<Courses> getCourses() {
        return adminService.getCourses();
    }

    

    
}
