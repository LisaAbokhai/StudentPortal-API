package com.example.student.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.student.model.admin.Admin;
import com.example.student.model.admission.Admission;
import com.example.student.model.admission.AdmissionStatusEnum;
import com.example.student.model.student.Courses;
import com.example.student.model.student.Student;
import com.example.student.model.teacher.Teacher;
import com.example.student.repository.AdminRepository;
import com.example.student.repository.AdmissionRepository;
import com.example.student.repository.CoursesRepository;
import com.example.student.repository.StudentRepository;
import com.example.student.repository.TeacherRepository;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final AdmissionRepository admissionRepository;
    private final CoursesRepository coursesRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository, TeacherRepository teacherRepository, StudentRepository studentRepository, AdmissionRepository admissionRepository, CoursesRepository coursesRepository) {
        this.adminRepository = adminRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.admissionRepository = admissionRepository;
        this.coursesRepository = coursesRepository;
    }

    public Admin createAdmin(String name, String email) {
        Admin admin = new Admin();
        admin.setName(name);
        admin.setEmail(email);
        return adminRepository.save(admin);
    }

    

    public Teacher createTeacher(String name, String email) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setEmail(email);
        return teacherRepository.save(teacher);
    }


    public Student createStudent(Long id) {
        Admission admission = admissionRepository.findAdmissionById(id);
        admission.setAdmissionStatus(AdmissionStatusEnum.APPROVED);
        admissionRepository.save(admission);

        Student student = new Student();
        student.setTitle(admission.getTitle());
        student.setFirstname(admission.getFirstName());
        student.setMiddlename(admission.getMiddleName());
        student.setSurname(admission.getSurname());
        student.setMaritalStatus(admission.getMaritalStatus());
        student.setMaidenName(admission.getMaidenName());
        student.setReligion(admission.getReligion());
        student.setNationality(admission.getNationality());
        student.setState(admission.getState());
        student.setDateOfBirth(admission.getDateOfBirth());
        student.setLocalGovtAreaOfOrigin(admission.getLocalGovtAreaOfOrigin());
        student.setPermanentHomeAddreess(admission.getPermanentHomeAddreess());
        student.setEmail(admission.getEmail());
        student.setProgramme(admission.getProgramme());
        
        return studentRepository.save(student);

    }

    //upload courses to couses repository
    public void uploadCourses( MultipartFile file ) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;

            reader.readLine(); //skip the header
            
            while ((line = reader.readLine()) != null) {

                String[] values = line.split(",");
                String courseCode = values[0]; //course code is a string
                String courseName = values[1];

                Teacher teacher = teacherRepository.findByName(values[2]);

                Courses course = new Courses();
                course.setCourseCode(courseCode);
                course.setCourseName(courseName);
                course.setTeacher(teacher);
    
                coursesRepository.save(course);
        

            }
        } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public List<Courses> getCourses() {
        return coursesRepository.findAll();
    }


}



