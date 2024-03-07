package org.example.miniproj.service;

import org.example.miniproj.model.Trip;

import java.util.List;
import java.util.Optional;

public interface TripService {
    List<Trip> getAllTrips();
    Optional<Trip> getTripById(Integer id);
    Trip saveTrip(Trip trip);
    void deleteTrip(Integer id);
}
