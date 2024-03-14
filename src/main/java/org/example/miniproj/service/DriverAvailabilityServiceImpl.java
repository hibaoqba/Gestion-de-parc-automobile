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

@Service
public class DriverAvailabilityServiceImpl implements DriverAvailabilityService {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private TripRepository tripRepository;
    @Override
    public boolean isDriverAvailable(String driverId, LocalDate startDate, LocalDate endDate) {
        Driver driver = driverRepository.getById(driverId);
        List<Trip> trips = driver.getTrips();
        for (Trip trip : trips) {
            LocalDate tripStartDate = trip.getDepartureDate();
            LocalDate tripEndDate = trip.getArrivalDate();
            if ((tripStartDate.isBefore(endDate) || tripStartDate.isEqual(endDate)) &&
                    (tripEndDate.isAfter(startDate) || tripEndDate.isEqual(startDate))) {
                return false;
            }
            if (tripStartDate.isAfter(startDate) && tripEndDate.isBefore(endDate)) {
                return false;
            }
            if (tripStartDate.isBefore(startDate) && (tripEndDate.isAfter(startDate) || tripEndDate.isEqual(startDate))) {
                return false;
            }
            if ((tripStartDate.isBefore(endDate) || tripStartDate.isEqual(endDate)) && tripEndDate.isAfter(endDate)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public List<Driver> getAllAvailableDrivers(LocalDate startDate, LocalDate endDate) {
        List<Driver> allDrivers = driverRepository.findAll();
        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : allDrivers) {
            if (isDriverAvailable(driver.getMatricule(), startDate, endDate)) {
                availableDrivers.add(driver);
            }
        }
        return availableDrivers;
    }

}
