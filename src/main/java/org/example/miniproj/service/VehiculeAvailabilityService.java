package org.example.miniproj.service;

import org.example.miniproj.model.Driver;
import org.example.miniproj.model.Vehicule;
import org.example.miniproj.repository.DriverRepository;
import org.example.miniproj.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface VehiculeAvailabilityService {
    List<Vehicule> getAllAvailableVehicules(LocalDate startDate, LocalDate endDate );
    boolean isVehiculeAvailable(Integer vehiculeId,LocalDate startDate, LocalDate endDate);


}
