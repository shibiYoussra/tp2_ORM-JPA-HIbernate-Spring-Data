package org.example.tp2_jee.repository;

import org.example.tp2_jee.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
