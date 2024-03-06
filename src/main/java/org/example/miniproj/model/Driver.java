package org.example.miniproj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="driver")
public class Driver {
    @Id
    @GeneratedValue
    private int matricule;
    private String prenom;
    private String nom;
    private LocalDate dateNaissance;
    private String cin;
    private String numeroPermis;
    private LocalDate dateDelivrancePermis;
    private String typePermis;
}
