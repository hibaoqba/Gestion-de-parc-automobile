package org.example.miniproj.service;

import org.example.miniproj.model.Vehicule;

import java.util.List;

public interface VehiculeService {
    Vehicule saveVehicule(Vehicule vehicule);
    Vehicule getVehiculeById(String id);
    List<Vehicule> getAllVehicules();
    void deleteVehiculeById(String id);
}
