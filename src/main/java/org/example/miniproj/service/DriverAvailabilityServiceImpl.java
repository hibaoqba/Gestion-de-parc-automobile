package org.example.miniproj.service;

import org.example.miniproj.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverAvailabilityServiceImpl implements DriverAvailabilityService {

    @Autowired
    private DriverService driverService;

    @Override
    public List<Driver> getAllAvailableDrivers() {
        // Implement the logic to retrieve all available drivers
        // For example, you can retrieve all drivers and filter out the ones that are not available
        return driverService.getAllDrivers(); // Assuming getAllDrivers() returns a list of all drivers
    }

    @Override
    public boolean isDriverAvailable(String driverId) {
        // Implement the logic to check if a driver with the given ID is available
        // For example, you can retrieve the driver by ID and check their availability status
        return driverService.getDriverById(driverId)
                .map(Driver::isAvailable) // Assuming Driver class has a method isAvailable() to check availability
                .orElse(false); // If the driver is not found, consider them unavailable
    }
}
