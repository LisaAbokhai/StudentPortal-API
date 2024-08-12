package com.example.student.model.teacher;

import java.util.List;
import java.util.Set;

import com.example.student.model.student.Courses;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Teacher{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       
    private Long id; 

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private Set<Courses> courses;

    @OneToMany(mappedBy = "teacher")
    private List<ResultUpload> resultUploads;



    
     
}
