package com.example.student.model.student;


import java.util.List;

import com.example.student.model.teacher.Results;
import com.example.student.model.teacher.Teacher;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Courses {
    @Id
    private String courseCode; //string because of csv file

    private String courseName;


    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "name")
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    private List<Results> results;

    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}