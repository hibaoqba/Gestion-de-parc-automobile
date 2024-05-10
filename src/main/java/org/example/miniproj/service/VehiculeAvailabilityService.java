package org.example.miniproj.service;

import org.example.miniproj.model.Vehicule;

import java.time.LocalDate;
import java.util.List;

public interface VehiculeAvailabilityService {
    List<Vehicule> getAllAvailableVehicules(LocalDate startDate, LocalDate endDate );
    boolean isVehiculeAvailable(String vehiculeId,LocalDate startDate, LocalDate endDate);
}

