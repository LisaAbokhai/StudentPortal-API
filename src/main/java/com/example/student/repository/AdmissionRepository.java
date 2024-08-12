package com.example.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.student.model.admission.Admission;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Long>{

    Long countByEmail(String email);

    @Query("SELECT a FROM Admission a WHERE a.id = :id")
    Admission findAdmissionById(@Param("id") Long id); //findbyid requires optional and that requires too many changes
}
