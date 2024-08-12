package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.student.model.admission.Admission;
import com.example.student.service.AdmissionService;



@RestController
@RequestMapping("/admission")

public class AdmissionController {

    private final AdmissionService admissionService;

    @Autowired
    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;

    }
    
        @GetMapping("/welcome")
        public List<Admission> getAdmissions() {
            return admissionService.getAdmissions();
        }

        @PostMapping("/application")
        public ResponseEntity<Admission> registerNewAdmission(@RequestBody Admission admission) {
            Admission newAdmission = admissionService.addNewAdmission(admission);
            return ResponseEntity.ok(newAdmission);
        }
        

    
}
