package com.project.finartz.service.impl;

import com.project.finartz.base.dto.Airline;
import com.project.finartz.base.mapper.DozerMapperUtility;
import com.project.finartz.entity.AirlineEntity;
import com.project.finartz.repository.AirlineRepository;
import com.project.finartz.service.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AirlineServiceImpl implements IAirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private DozerMapperUtility dozerMapperUtility;

    private static final String mapId = "AirlineEntity_Airline";

    @Override
    public List<Airline> fetchAllAirlineList() {
        List<AirlineEntity> airlineEntityList = airlineRepository.findAll();

        return dozerMapperUtility.map(airlineEntityList, Airline.class, mapId);
    }

    @Override
    public Airline inquireAirlineById(Long airlineId) {
        AirlineEntity airlineEntity = airlineRepository.findByAirlineId(airlineId);

        return dozerMapperUtility.map(airlineEntity, Airline.class, mapId);
    }

    @Override
    @Transactional
    public Airline createAirline(Airline airline) {
        AirlineEntity airlineEntity = dozerMapperUtility.map(airline, AirlineEntity.class, mapId);
        airlineRepository.save(airlineEntity);

        return dozerMapperUtility.map(airlineEntity, Airline.class, mapId);
    }

    @Override
    @Transactional
    public Airline updateAirline(Airline airline, Long airlineId) {
        AirlineEntity airlineEntity = airlineRepository.findByAirlineId(airlineId);
        airlineEntity.setName(airline.getName());
        airlineRepository.save(airlineEntity);

        return dozerMapperUtility.map(airlineEntity, Airline.class, mapId);
    }

    @Override
    public Airline deleteAirlineById(Long airlineId) {
        AirlineEntity airlineEntity = airlineRepository.findByAirlineId(airlineId);
        airlineRepository.deleteById(airlineId);

        return dozerMapperUtility.map(airlineEntity, Airline.class, mapId);
    }
}
