package com.example.student.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.student.model.admission.Admission;
import com.example.student.repository.AdmissionRepository;

import static com.example.student.model.admission.AdmissionTypeEnum.*;
import static com.example.student.model.student.MaritalEnum.*;
import static com.example.student.model.student.ProgrammeEnum.*;
import static com.example.student.model.student.ReligionEnum.*;
import static java.time.LocalDate.of;

import java.util.List;



@Configuration
public class AdmissionConfig {
    @Bean
    CommandLineRunner commandLineRunner(AdmissionRepository repository) {
        return args -> {
           Admission john = new Admission(
                1L,
                "Mr",
                "John",
                "Doe",
                "Smith",
                SINGLE,
                "Doe",
                CHRISTIAN,
                of(1990, 1, 1),
                "Nigerian",
                "Lagos",
                "etsako",
                "24 agbonyin avenue",
                "08012345678",
                "abokhailisa@gmail.com",
                UNDERGRADUATE,
                ZOOLOGY);
            Admission lisa = new Admission(
                2L,
                "Mr",
                "John",
                "Doe",
                "Smith",
                SINGLE,
                "Doe",
                CHRISTIAN,
                of(1990, 1, 1),
                "Nigerian",
                "Lagos",
                "etsako",
                "24 agbonyin avenue",
                "08012345678",
                "abokhailisa@gmail.com",
                UNDERGRADUATE,
                YORUBA);
            Admission mariam = new Admission(
                3L,
                "Mr",
                "John",
                "Doe",
                "Smith",
                SINGLE,
                "Doe",
                CHRISTIAN,
                of(1990, 1, 1),
                "Nigerian",
                "Lagos",
                "etsako",
                "24 agbonyin avenue",
                "08012345678",
                "abokhailisa@gmail.com",
                UNDERGRADUATE,
                BIOLOGY);       

            repository.saveAll(
                List.of(john, lisa, mariam)
            );
        
        };
    }

    
}
