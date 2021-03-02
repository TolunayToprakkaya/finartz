package com.project.finartz.repository;

import com.project.finartz.entity.AirlineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<AirlineEntity, Long> {

    AirlineEntity findByAirlineId(Long airlineId);
}
