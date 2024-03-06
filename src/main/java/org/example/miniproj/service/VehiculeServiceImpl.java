package org.example.miniproj.service;

import org.example.miniproj.model.Vehicule;
import org.example.miniproj.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeServiceImpl implements VehiculeService{
    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule saveVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule getVehiculeById(String id) {
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        return optionalVehicule.orElse(null);
    }

    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public void deleteVehiculeById(String id) {
        vehiculeRepository.deleteById(id);
    }
}
