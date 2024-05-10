package org.example.miniproj.service;

import org.example.miniproj.model.Driver;
import org.example.miniproj.model.Trip;
import org.example.miniproj.model.Vehicule;
import org.example.miniproj.repository.DriverRepository;
import org.example.miniproj.repository.TripRepository;
import org.example.miniproj.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class VehiculeAvailabilityServiceImpl implements  VehiculeAvailabilityService{
    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Autowired
    private TripRepository tripRepository;
    public boolean isVehiculeAvailable(String vehiculeId, LocalDate startDate, LocalDate endDate) {
        Vehicule vehicule = vehiculeRepository.findById(vehiculeId).orElse(null);
        if (vehicule == null) {
            return false;
        }
        List<Trip> trips = vehicule.getTrips();
        return trips.stream()
                .filter(trip -> (trip.getDepartureDate().isBefore(endDate) || trip.getDepartureDate().isEqual(endDate)) &&
                        (trip.getArrivalDate().isAfter(startDate) || trip.getArrivalDate().isEqual(startDate)))
                .findFirst()
                .isEmpty();
    }
    @Override
    public List<Vehicule> getAllAvailableVehicules(LocalDate startDate, LocalDate endDate) {
        return vehiculeRepository.findAll().stream()
                .filter(vehicule -> isVehiculeAvailable(vehicule.getId(), startDate, endDate))
                .collect(Collectors.toList());
    }
}
