package com.example.student.model.teacher;



import java.time.LocalDate;

import com.example.student.model.student.Courses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString


@Entity
@Table
public class ResultUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filePath;

    @ManyToOne
    @JoinColumn(name = "teacher_name", referencedColumnName = "name")
    private Teacher teacher;

    private String name;



    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "courseCode")
    private Courses course;

    private String courseid;

    private String resultComment;

    private LocalDate resultDate;


}
