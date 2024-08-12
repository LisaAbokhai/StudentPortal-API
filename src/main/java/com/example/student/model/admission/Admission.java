package com.example.student.model.admission;

import java.time.LocalDate;

import com.example.student.model.student.MaritalEnum;
import com.example.student.model.student.ProgrammeEnum;
import com.example.student.model.student.ReligionEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
public class Admission {
    @Id
    @SequenceGenerator(
            name = "admission_sequence",
            sequenceName = "admission_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admission_sequence"
    )

    @Column(nullable = false)
    private Long id;

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

    private String phoneNumber;

    private String email;
    
    private AdmissionTypeEnum admissionType;

    private AdmissionStatusEnum admissionStatus;
    
    private ProgrammeEnum programme;

    public Admission(Long id,
        String title,
        String firstName,
        String middleName,
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
        AdmissionTypeEnum admissionType,
        ProgrammeEnum programme) {
                
            this.id = id;
            this.title = title;
            this.firstName = firstName;
            this.middleName = middleName;
            this.surname = surname;
            this.maritalStatus = maritalStatus;
            this.maidenName = maidenName;
            this.religion = religion;
            this.dateOfBirth = dateOfBirth;
            this.nationality = nationality;
            this.state = state;
            this.localGovtAreaOfOrigin = localGovtAreaOfOrigin;
            this.permanentHomeAddreess = permanentHomeAddreess;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.admissionType = admissionType;
            this.programme = programme;
            this.admissionStatus = AdmissionStatusEnum.PENDING;
        }




}


