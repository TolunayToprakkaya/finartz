package com.project.finartz.service.impl;

import com.project.finartz.base.dto.Route;
import com.project.finartz.base.mapper.DozerMapperUtility;
import com.project.finartz.entity.AirportEntity;
import com.project.finartz.entity.PlaneEntity;
import com.project.finartz.entity.RouteEntity;
import com.project.finartz.repository.AirportRepository;
import com.project.finartz.repository.PlaneRepository;
import com.project.finartz.repository.RouteRepository;
import com.project.finartz.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RouteServiceImpl implements IRouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private DozerMapperUtility dozerMapperUtility;

    private static final String mapId = "RouteEntity_Route";

    @Override
    public List<Route> fetchAllRouteList() {
        List<RouteEntity> routeEntityList = routeRepository.findAll();

        return dozerMapperUtility.map(routeEntityList, Route.class, mapId);
    }

    @Override
    public Route inquireRouteById(Long routeId) {
        RouteEntity routeEntity = routeRepository.findByRouteId(routeId);

        return dozerMapperUtility.map(routeEntity, Route.class, mapId);
    }

    @Override
    @Transactional
    public Route createRoute(Route route) {
        RouteEntity routeEntity = dozerMapperUtility.map(route, RouteEntity.class, mapId);
        routeRepository.save(routeEntity);

        return dozerMapperUtility.map(routeEntity, Route.class, mapId);
    }

    @Override
    @Transactional
    public Route updateRoute(Route route, Long routeId) {
        RouteEntity routeEntity = routeRepository.findByRouteId(routeId);
        routeEntity.setName(route.getName());
        routeEntity.setDepartureTime(route.getDepartureTime());

        PlaneEntity planeEntity = planeRepository.findByPlaneId(route.getPlane().getPlaneId());
        routeEntity.setPlaneEntity(planeEntity);

        AirportEntity airportEntityDeparturePlace = airportRepository.findByAirportId(route.getAirportDeparturePlace().getAirportId());
        routeEntity.setAirportEntityDeparturePlace(airportEntityDeparturePlace);

        AirportEntity airportEntityLandingPlace = airportRepository.findByAirportId(route.getAirportLandingPlace().getAirportId());
        routeEntity.setAirportEntityLandingPlace(airportEntityLandingPlace);

        routeRepository.save(routeEntity);

        return dozerMapperUtility.map(routeEntity, Route.class, mapId);
    }

    @Override
    public Route deleteRouteById(Long routeId) {
        RouteEntity routeEntity = routeRepository.findByRouteId(routeId);
        routeRepository.deleteById(routeId);

        return dozerMapperUtility.map(routeEntity, Route.class, mapId);
    }
}
