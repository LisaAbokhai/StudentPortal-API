package com.example.student.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.student.model.teacher.ResultId;
import com.example.student.model.teacher.ResultUpload;
import com.example.student.model.teacher.Results;
import com.example.student.model.teacher.Teacher;
import com.example.student.repository.ResultUploadRepository;
import com.example.student.repository.ResultsRepository;
import com.example.student.repository.TeacherRepository;



@Service
public class ResultsService {
    
    private final ResultsRepository resultsRepository;
    private final ResultUploadRepository resultUploadRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public ResultsService(ResultsRepository resultsRepository, ResultUploadRepository resultUploadRepository, TeacherRepository teacherRepository) {
        this.resultsRepository = resultsRepository;
        this.resultUploadRepository = resultUploadRepository;
        this.teacherRepository = teacherRepository;
    }


    public void updateGrades(MultipartFile file, String courseCode) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Long matricNo = Long.parseLong(values[0]); // First value: matricNo
                int grade = Integer.parseInt(values[2]); // Third value: grade

                ResultId resultId = new ResultId(matricNo, courseCode);

                Results result = resultsRepository.findById(resultId)
                                                  .orElseThrow(() -> new IllegalArgumentException("Student not found: " + matricNo));

                // Update the grade
                result.setGrade(grade);

                resultsRepository.save(result);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing the uploaded file", e);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in the uploaded file", e);
        }
    }

    public void logUpload(String courseCode, String comment, String teacherName, MultipartFile file) {
        ResultUpload resultUpload = new ResultUpload();
        resultUpload.setCourseid(courseCode);
        resultUpload.setResultComment(comment);
        resultUpload.setFilePath(file.getOriginalFilename());
        resultUpload.setResultDate(LocalDate.now());
        resultUpload.setName(teacherName);

        Teacher teacher = teacherRepository.findByName(teacherName); // Fetch teacher based on name
        if (teacher != null) {
            resultUpload.setTeacher(teacher); // Set the teacher in ResultUpload
        } else {
            throw new IllegalArgumentException("Teacher not found: " + teacherName);
        }

        resultUploadRepository.save(resultUpload);
    }


}
