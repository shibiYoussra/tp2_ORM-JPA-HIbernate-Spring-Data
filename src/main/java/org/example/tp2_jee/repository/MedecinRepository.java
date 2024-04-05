package org.example.tp2_jee.repository;

import org.example.tp2_jee.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
