package com.project.finartz.repository;

import com.project.finartz.entity.PlaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<PlaneEntity, Long> {

    PlaneEntity findByPlaneId(Long planeId);
}
