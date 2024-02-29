package org.example.miniproj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vehicule")
public class Vehicule {
    @Id
    private String identifiantUnique;
    private String marque;
    @Enumerated(EnumType.STRING)
    private VehiculeType typeVehicule;
    private int kilometrage;
    private boolean disponibilite;
    private String typePermisRequis;
}
