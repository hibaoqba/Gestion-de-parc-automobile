package org.example.miniproj.service;

import org.example.miniproj.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<Driver> getAllDrivers();
    Optional<Driver> getDriverById(String matricule);
    Driver saveDriver(Driver driver);
    void deleteDriver(String matricule);
}
