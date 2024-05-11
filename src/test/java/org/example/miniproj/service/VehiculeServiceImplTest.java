package org.example.miniproj.service;
import org.example.miniproj.model.Vehicule;
import org.example.miniproj.repository.VehiculeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class VehiculeServiceImplTest {

    @Mock
    private VehiculeRepository vehiculeRepository;

    @InjectMocks
    private VehiculeServiceImpl vehiculeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveVehicule_shouldReturnSavedVehicule() {
        // Given
        Vehicule vehiculeToSave = new Vehicule();
        when(vehiculeRepository.save(vehiculeToSave)).thenReturn(vehiculeToSave);
        Vehicule savedVehicule = vehiculeService.saveVehicule(vehiculeToSave);
        assertNotNull(savedVehicule);
        assertEquals(vehiculeToSave, savedVehicule);
    }

    @Test
    void getVehiculeById_shouldReturnVehiculeIfExists() {
        // Given
        Integer vehiculeId = 1;
        Vehicule expectedVehicule = new Vehicule();
        when(vehiculeRepository.findById(vehiculeId)).thenReturn(Optional.of(expectedVehicule));

        // When
        Vehicule actualVehicule = vehiculeService.getVehiculeById(vehiculeId);

        // Then
        assertNotNull(actualVehicule);
        assertEquals(expectedVehicule, actualVehicule);
    }

    @Test
    void getVehiculeById_shouldReturnNullIfVehiculeDoesNotExist() {
        // Given
        Integer vehiculeId = 1;
        when(vehiculeRepository.findById(vehiculeId)).thenReturn(Optional.empty());

        // When
        Vehicule actualVehicule = vehiculeService.getVehiculeById(vehiculeId);

        // Then
        assertEquals(null, actualVehicule);
    }

    @Test
    void getAllVehicules_shouldReturnAllVehicules() {
        // Given
        List<Vehicule> expectedVehicules = Arrays.asList(new Vehicule(), new Vehicule());
        when(vehiculeRepository.findAll()).thenReturn(expectedVehicules);

        // When
        List<Vehicule> actualVehicules = vehiculeService.getAllVehicules();

        // Then
        assertEquals(expectedVehicules.size(), actualVehicules.size());
        assertEquals(expectedVehicules, actualVehicules);
    }

    @Test
    void deleteVehiculeById_shouldDeleteVehiculeIfExists() {
        // Given
        Integer vehiculeId = 1;

        // When
        vehiculeService.deleteVehiculeById(vehiculeId);

        // Then
        verify(vehiculeRepository, times(1)).deleteById(vehiculeId);
    }
}
