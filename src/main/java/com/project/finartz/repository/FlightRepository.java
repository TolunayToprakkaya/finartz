package com.project.finartz.repository;

import com.project.finartz.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    FlightEntity findByFlightId(Long flightId);
}
