package com.project.finartz.repository;

import com.project.finartz.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<AirportEntity, Long> {

    AirportEntity findByAirportId(Long airportId);
}
