package com.project.finartz.service.impl;

import com.project.finartz.base.dto.Airport;
import com.project.finartz.base.mapper.DozerMapperUtility;
import com.project.finartz.entity.AirportEntity;
import com.project.finartz.repository.AirportRepository;
import com.project.finartz.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AirportServiceImpl implements IAirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private DozerMapperUtility dozerMapperUtility;

    private static final String mapId = "AirportEntity_Airport";

    @Override
    public List<Airport> fetchAllAirportList() {
        List<AirportEntity> airportEntityList = airportRepository.findAll();

        return dozerMapperUtility.map(airportEntityList, Airport.class, mapId);
    }

    @Override
    public Airport inquireAirportById(Long airportId) {
        AirportEntity airportEntity = airportRepository.findByAirportId(airportId);

        return dozerMapperUtility.map(airportEntity, Airport.class, mapId);
    }

    @Override
    @Transactional
    public Airport createAirport(Airport airport) {
        AirportEntity airportEntity = dozerMapperUtility.map(airport, AirportEntity.class, mapId);
        airportRepository.save(airportEntity);

        return dozerMapperUtility.map(airportEntity, Airport.class, mapId);
    }

    @Override
    @Transactional
    public Airport updateAirport(Airport airport, Long airportId) {
        AirportEntity airportEntity = airportRepository.findByAirportId(airportId);
        airportEntity.setName(airport.getName());
        airportRepository.save(airportEntity);

        return dozerMapperUtility.map(airportEntity, Airport.class, mapId);
    }

    @Override
    public Airport deleteAirportById(Long airportId) {
        AirportEntity airportEntity = airportRepository.findByAirportId(airportId);
        airportRepository.deleteById(airportId);

        return dozerMapperUtility.map(airportEntity, Airport.class, mapId);
    }
}
