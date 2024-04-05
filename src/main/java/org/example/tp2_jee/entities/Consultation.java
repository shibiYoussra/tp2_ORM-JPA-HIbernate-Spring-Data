package org.example.tp2_jee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateConsultation;
    private Date RapportConsultation;
    @OneToOne
    private RendezVous rendezVous;
}
