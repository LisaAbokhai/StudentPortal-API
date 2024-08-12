package com.example.student.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.admission.Admission;
import com.example.student.repository.AdmissionRepository;


@Service
public class AdmissionService {

    private final AdmissionRepository admissionRepository;

    @Autowired
    public AdmissionService(AdmissionRepository admissionRepository) {
        this.admissionRepository = admissionRepository;
    }

    public List<Admission> getAdmissions() {
        return admissionRepository.findAll();
    }

    public Admission addNewAdmission(Admission admission) {

        admissionRepository.countByEmail(admission.getEmail());
        return admissionRepository.save(admission);
        
    }
}
 


    
