package org.example.miniproj.service;

import jakarta.transaction.Transactional;
import org.example.miniproj.model.Trip;
import org.example.miniproj.model.VehiculeType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class TripServiceImplTest {

    @Autowired
    TripService tripService;
    @Test
public void saveTripTest(){
        Trip trip= Trip.builder()
                .departureDate(LocalDate.of(2024,21,3))
                .arrivalDate(LocalDate.of(2024,30,3))
                .departureTime(LocalTime.of(2,30))
                .arrivalTime(LocalTime.of(2,30))
                .destination("agadir")
                .vehiculeType(VehiculeType.TRUCK)
                .build();
        Trip savedTrip=tripService.saveTrip(trip);
        assertNotNull(savedTrip);
    }

}