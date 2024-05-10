package org.example.miniproj.service;

import org.example.miniproj.model.Driver;
import org.example.miniproj.repository.DriverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
class DriverServiceImplTest {

    @Mock
    private DriverRepository driverRepository;
    @InjectMocks
    private DriverServiceImpl driverService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void getAllDrivers_shouldReturnAllDrivers() {
        List<Driver> expectedDrivers = Arrays.asList(
                new Driver("123", "John", "Doe", LocalDate.of(1990, 5, 15), "ABC123", null, new ArrayList<>()),
                new Driver("456", "Jane", "Smith", LocalDate.of(1985, 10, 20), "DEF456", null, new ArrayList<>())
        );
        when(driverRepository.findAll()).thenReturn(expectedDrivers);
        List<Driver> actualDrivers = driverService.getAllDrivers();
        assertEquals(expectedDrivers.size(), actualDrivers.size());
        assertTrue(actualDrivers.containsAll(expectedDrivers));
    }

    @Test
    void getDriverById_shouldReturnDriverIfExists() {
        String driverId = "123";
        Driver expectedDriver = new Driver(driverId, "John", "Doe", LocalDate.of(1990, 5, 15), "ABC123", null, new ArrayList<>());
        when(driverRepository.findById(driverId)).thenReturn(Optional.of(expectedDriver));
        Optional<Driver> actualDriverOptional = driverService.getDriverById(driverId);
        assertTrue(actualDriverOptional.isPresent());
        assertEquals(expectedDriver, actualDriverOptional.get());
    }

    @Test
    void getDriverById_shouldReturnEmptyOptionalIfDriverDoesNotExist() {
        String driverId = "999";
        when(driverRepository.findById(driverId)).thenReturn(Optional.empty());
        Optional<Driver> actualDriverOptional = driverService.getDriverById(driverId);
        assertTrue(actualDriverOptional.isEmpty());
    }
    @Test
    void saveDriver_shouldReturnSavedDriver() {
        Driver driverToSave = new Driver("789", "Alice", "Johnson", LocalDate.of(1995, 8, 25), "GHI789", null, new ArrayList<>());
        when(driverRepository.save(driverToSave)).thenReturn(driverToSave);
        Driver savedDriver = driverService.saveDriver(driverToSave);
        assertEquals(driverToSave, savedDriver);
    }

    @Test
    void deleteDriver_shouldDeleteDriverIfExists() {
        String driverId = "123";
        driverService.deleteDriver(driverId);
        verify(driverRepository, times(1)).deleteById(driverId);
    }


}
