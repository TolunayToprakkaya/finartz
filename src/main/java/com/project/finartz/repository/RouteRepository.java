package com.project.finartz.repository;

import com.project.finartz.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

    RouteEntity findByRouteId(Long routeId);
}
