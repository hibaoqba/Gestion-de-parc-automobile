package org.example.miniproj.repository;

import org.example.miniproj.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule,String> {

}
