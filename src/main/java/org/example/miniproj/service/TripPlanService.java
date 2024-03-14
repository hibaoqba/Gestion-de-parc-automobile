package org.example.miniproj.service;

import org.example.miniproj.dto.TripRequestDTO;
import org.example.miniproj.model.Trip;
import org.example.miniproj.model.VehiculeType;
import org.example.miniproj.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripPlanService {
    @Autowired
    private TripRepository tripRepository;

    public void registerTrip(TripRequestDTO tripRequestDTO) {
        // Perform validation and business logic checks here
        // Example:
        Trip trip = Trip.builder()
                .departureDate(tripRequestDTO.getDepartureDate())
                .departureTime(tripRequestDTO.getDepartureTime())
                .arrivalDate(tripRequestDTO.getArrivalDate())
                .arrivalTime(tripRequestDTO.getArrivalTime())
                .departure(tripRequestDTO.getDeparture())
                .destination(tripRequestDTO.getDestination())
                .vehiculeType(VehiculeType.valueOf(tripRequestDTO.getVehiculeType()))
                .numberOfPassengers(tripRequestDTO.getNumberOfPassengers())
                .otherDetails(tripRequestDTO.getOtherDetails())
                .build();
        // Save trip in repository
        tripRepository.save(trip);
    }

}
