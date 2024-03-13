package org.example.miniproj.service;

import org.example.miniproj.model.Driver;
import org.example.miniproj.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Optional<Driver> getDriverById(String matricule) {
        return driverRepository.findByMatricule(matricule);
    }




    @Override
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public void deleteDriver(String matricule) {
        driverRepository.deleteByMatricule(matricule);
    }
}
