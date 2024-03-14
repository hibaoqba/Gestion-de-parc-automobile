package org.example.miniproj.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
public class TripRequestDTO {
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private String departure;
    private String destination;
    private String vehiculeType;
    private int numberOfPassengers;
    private String otherDetails;
}
