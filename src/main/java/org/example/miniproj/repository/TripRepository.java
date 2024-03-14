package org.example.miniproj.repository;

import org.example.miniproj.model.Driver;
import org.example.miniproj.model.Trip;
import org.example.miniproj.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip,Integer> {
    List<Trip> findByDriverAndDepartureDateBetween(Driver driver, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime);
    List<Trip> findByvehiculeAndDepartureDateBetween(Vehicule vehicule, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime);
}
