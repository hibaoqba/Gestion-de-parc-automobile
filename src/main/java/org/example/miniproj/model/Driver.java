package org.example.miniproj.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="driver")
public class Driver {
    @Id
    private String matricule;
    private String prenom;
    private String nom;
    private LocalDate dateNaissance;
    private String cin;
    private String numeroPermis;
    private LocalDate dateDelivrancePermis;
    private String typePermis;
    @OneToMany(mappedBy = "driver")
    private List<Trip> trips = new ArrayList<>();
}
