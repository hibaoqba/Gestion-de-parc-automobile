package org.example.miniproj.repository;

import org.example.miniproj.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,String> {
    @Query("")
    List<Driver> findByTripsDepartureDateBetweenOrTripsArrivalDateBetween(
            LocalDate startDate1, LocalDate endDate1,
            LocalDate startDate2, LocalDate endDate2);

}
