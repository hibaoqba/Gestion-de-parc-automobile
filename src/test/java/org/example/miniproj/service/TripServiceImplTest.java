package org.example.miniproj.service;
import org.example.miniproj.model.VehiculeType;
import org.example.miniproj.model.Driver;
import org.example.miniproj.model.Trip;
import org.example.miniproj.model.Vehicule;
import org.example.miniproj.repository.TripRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TripServiceImplTest {

    @Mock
    private TripRepository tripRepository;

    @InjectMocks
    private TripServiceImpl tripService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllTrips() {
        // Given
        List<Trip> expectedTrips = Arrays.asList(
                new Trip(1, "Departure", "Destination", LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now(), 2, "Details",
                      VehiculeType.TRUCK, new Driver(), new Vehicule()),
                new Trip(2, "Departure", "Destination", LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now(), 2, "Details",
                        VehiculeType.TRUCK, new Driver(), new Vehicule())
        );
        when(tripRepository.findAll()).thenReturn(expectedTrips);

        // When
        List<Trip> actualTrips = tripService.getAllTrips();

        // Then
        assertEquals(expectedTrips.size(), actualTrips.size());
        assertTrue(actualTrips.containsAll(expectedTrips));
    }

    @Test
    void testGetTripById() {
        // Given
        int id = 1;
        Trip expectedTrip = new Trip(id, "Departure", "Destination", LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now(), 2, "Details"
                ,VehiculeType.TRUCK, new Driver(),new Vehicule());
        when(tripRepository.findById(id)).thenReturn(Optional.of(expectedTrip));

        // When
        Optional<Trip> actualTripOptional = tripService.getTripById(id);

        // Then
        assertTrue(actualTripOptional.isPresent());
        assertEquals(expectedTrip, actualTripOptional.get());
    }

    @Test
    void testSaveTrip() {
        // Given
        Vehicule vehicule = new Vehicule();
        Driver driver = new Driver();
        Trip tripToSave = new Trip(1, "Departure", "Destination", LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now(), 2, "Details",
              VehiculeType.TRUCK, driver,vehicule);
        when(tripRepository.save(tripToSave)).thenReturn(tripToSave);

        // When
        Trip savedTrip = tripService.saveTrip(tripToSave);

        // Then
        assertEquals(tripToSave, savedTrip);
    }

    @Test
    void testDeleteTrip() {
        // Given
        int id = 1;

        // When
        tripService.deleteTrip(id);

        // Then
        verify(tripRepository, times(1)).deleteById(id);
    }
}

