package org.example.miniproj.repository;

import org.example.miniproj.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,String> {
    Optional<Driver> findByMatricule(String matricule);

}
