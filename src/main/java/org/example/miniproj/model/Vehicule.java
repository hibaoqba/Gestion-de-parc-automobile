package org.example.miniproj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vehicule")
public class Vehicule {
    @Id
    @GeneratedValue
    private String id;
    private String marque;
    private String modele;
    @Enumerated(EnumType.STRING)
    private VehiculeType typeVehicule;
    private int kilometrage;
    private boolean disponibilite;
    private String typePermisRequis;
    @OneToMany(mappedBy = "vehicule")
    private List<Trip> trips = new ArrayList<>();
}
