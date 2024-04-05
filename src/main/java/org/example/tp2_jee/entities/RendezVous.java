package org.example.tp2_jee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class RendezVous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateRDV;
    private Date heureRDV;
    private boolean annule;
    private StatusRDV status;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
