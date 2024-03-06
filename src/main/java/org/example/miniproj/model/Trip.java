package org.example.miniproj.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table()
public class Trip {

    @Id
    @GeneratedValue
    private Integer id;

    private String departure;
    private String destination;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int numberOfPassengers;
    @Enumerated(EnumType.STRING)
    private VehiculeType vehiculeType;
    @ManyToOne
    @JoinColumn(name="matricule")
    private Driver driver;
    @ManyToOne
    @JoinColumn(name = "id")
    private Vehicule vehicule;

}