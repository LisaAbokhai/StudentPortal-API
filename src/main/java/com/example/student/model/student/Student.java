package com.example.student.model.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import java.util.Set;

import com.example.student.model.teacher.Results;

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

    private String firstname;

    private String middlename;

    private String surname;

    private MaritalEnum maritalStatus;

    private String maidenName;

    private ReligionEnum religion;

    private LocalDate dateOfBirth;

    private String nationality;

    private String state;

    private String localGovtAreaOfOrigin;

    private String permanentHomeAddreess;

    private String phoneNumber;

    private String email;

    private ProgrammeEnum programme;

    private String nextOfKin = "Not Set";

    private String kinPhoneNumber = "Not Set";

    private String kinAddress = "Not Set";

    private String sponsor = "Not Set";

    private String sponsorPhoneNumber = "Not Set";

    private String sponsorAddress = "Not Set";

    private byte[] passport = null;

    private String School = "Not Set";

    private InstitutionEnum institution = InstitutionEnum.OTHER;

    
    private byte[] birthCertificate = null;

    private byte[] jambAdmission = null;

    private byte[] jambResult = null;

    private byte[] oLevel = null;

    private byte[] referenceLetter = null;

    private byte[] originCertificate = null;

    private byte[] testimonal = null;

    private byte[] medicalReport = null;

    private byte[] admissionLetter = null;

    @OneToMany(mappedBy = "student")
    private Set<Results> results;


    public Student(
        String title,
        String firstname,
        String middlename,
        String surname,
        MaritalEnum maritalStatus,
        String maidenName,
        ReligionEnum religion,
        LocalDate dateOfBirth,
        String nationality,
        String state,
        String localGovtAreaOfOrigin,
        String permanentHomeAddreess,
        String phoneNumber,
        String email,
        String nextOfKin,
        String kinPhoneNumber,
        String kinAddress,
        String sponsor,
        String sponsorPhoneNumber,
        String sponsorAddress,
        byte[] passportphoto,
        String School,
        InstitutionEnum institution,
        byte[] birthCertificate,
        byte[] jambAdmission,
        byte[] jambResult,
        byte[] oLevel,
        byte[] referenceLetter,
        byte[] originCertificate,
        byte[] testimonal,
        byte[] medicalReport,
        byte[] admissionLetter
    
    ) {}
    

    


    
}
