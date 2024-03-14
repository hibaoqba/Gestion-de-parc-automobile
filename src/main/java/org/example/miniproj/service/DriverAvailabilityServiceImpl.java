package org.example.miniproj.service;

import org.example.miniproj.model.Driver;
import org.example.miniproj.model.Trip;
import org.example.miniproj.repository.DriverRepository;
import org.example.miniproj.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverAvailabilityServiceImpl implements DriverAvailabilityService {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private TripRepository tripRepository;
    @Override
    public boolean isDriverAvailable(String driverId, LocalDate startDate, LocalDate endDate) {
        Driver driver = driverRepository.findById(driverId).orElse(null);
        if (driver == null) {
            return false;
        }
        List<Trip> trips = driver.getTrips();
        return trips.stream()
                .filter(trip -> (trip.getDepartureDate().isBefore(endDate) || trip.getDepartureDate().isEqual(endDate)) &&
                        (trip.getArrivalDate().isAfter(startDate) || trip.getArrivalDate().isEqual(startDate)))
                .findFirst()
                .isEmpty();
    }
    @Override
    public List<Driver> getAllAvailableDrivers(LocalDate startDate, LocalDate endDate) {
        return driverRepository.findAll().stream()
                .filter(driver -> isDriverAvailable(driver.getMatricule(), startDate, endDate))
                .collect(Collectors.toList());
    }

}
