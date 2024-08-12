package com.example.student.model.teacher;

import com.example.student.model.student.Courses;
import com.example.student.model.student.Student;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
public class Results {

    @EmbeddedId
    private ResultId id;

    @ManyToOne
    @MapsId("matricNo")
    private Student student;

    @ManyToOne
    @MapsId("courseCode")
    private Courses course;

    private int grade = 0;
}