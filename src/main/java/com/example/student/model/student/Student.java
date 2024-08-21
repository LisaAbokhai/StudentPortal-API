package com.example.student.model.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import java.util.Set;

import com.example.student.model.teacher.Results;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString 

@Entity
@Table
public class Student{
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long matricNo;

    private String title;

    private String firstName;

    private String middleName;

    private String surname;

    private MaritalEnum maritalStatus;

    private String maidenName;

    private ReligionEnum religion;

    private LocalDate dateOfBirth;

    private String nationality;

    private String state;

    private String localGovtAreaOfOrigin;

    private String permanentHomeAddreess;

    private String phoneNumber = "Not set";

    private String email;

    private ProgrammeEnum programme;

    private String nextOfKin = "Not Set";

    private String kinPhoneNumber = "Not Set";

    private String kinAddress = "Not Set";

    private String sponsor = "Not Set";

    private String sponsorPhoneNumber = "Not Set";

    private String sponsorAddress = "Not Set";

    private byte[] passport = new byte[0];

    private String School = "Not Set";

    private InstitutionEnum institution = InstitutionEnum.OTHER;

    
    private byte[] birthCertificate = new byte[0];

    private byte[] jambResult = new byte[0];

    private byte[] oLevel = new byte[0];

    private byte[] referenceLetter = new byte[0];

    private byte[] medicalReport = new byte[0];


    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private Set<Results> results;


    
}
