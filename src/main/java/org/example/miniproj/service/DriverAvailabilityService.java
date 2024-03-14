package org.example.miniproj.service;

import org.example.miniproj.model.Driver;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DriverAvailabilityService {
    List<Driver> getAllAvailableDrivers(LocalDate startDate, LocalDate endDate );
    boolean isDriverAvailable(String driverId,LocalDate startDate, LocalDate endDate);
}
