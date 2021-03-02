package com.project.finartz.service.impl;

import com.project.finartz.base.dto.Flight;
import com.project.finartz.base.mapper.DozerMapperUtility;
import com.project.finartz.entity.FlightEntity;
import com.project.finartz.entity.RouteEntity;
import com.project.finartz.repository.FlightRepository;
import com.project.finartz.repository.RouteRepository;
import com.project.finartz.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FlightServiceImpl implements IFlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private DozerMapperUtility dozerMapperUtility;

    private static final String mapId = "FlightEntity_Flight";

    @Override
    public List<Flight> fetchAllFlightList() {
        List<FlightEntity> flightEntityList = flightRepository.findAll();

        return dozerMapperUtility.map(flightEntityList, Flight.class, mapId);
    }

    @Override
    public Flight inquireFlightById(Long flightId) {
        FlightEntity flightEntity = flightRepository.findByFlightId(flightId);

        return dozerMapperUtility.map(flightEntity, Flight.class, mapId);
    }

    @Override
    @Transactional
    public Flight createFlight(Flight flight) {
        FlightEntity flightEntity = dozerMapperUtility.map(flight, FlightEntity.class, mapId);
        flightRepository.save(flightEntity);

        return dozerMapperUtility.map(flightEntity, Flight.class, mapId);
    }

    @Override
    @Transactional
    public Flight updateFlight(Flight flight, Long flightId) {
        FlightEntity flightEntity = flightRepository.findByFlightId(flightId);
        flightEntity.setName(flight.getName());

        RouteEntity routeEntity = routeRepository.findByRouteId(flight.getRoute().getRouteId());
        flightEntity.setRouteEntity(routeEntity);

        flightRepository.save(flightEntity);

        return dozerMapperUtility.map(flightEntity, Flight.class, mapId);
    }

    @Override
    public Flight deleteFlightById(Long flightId) {
        FlightEntity flightEntity = flightRepository.findByFlightId(flightId);
        flightRepository.deleteById(flightId);

        return dozerMapperUtility.map(flightEntity, Flight.class, mapId);
    }
}
