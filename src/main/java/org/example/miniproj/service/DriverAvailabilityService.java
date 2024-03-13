package org.example.miniproj.service;

import org.example.miniproj.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverAvailabilityService {
    List<Driver> getAllAvailableDrivers();
    boolean isDriverAvailable(String driverId);
}
