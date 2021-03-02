package com.project.finartz.service.impl;

import com.project.finartz.base.dto.Plane;
import com.project.finartz.base.mapper.DozerMapperUtility;
import com.project.finartz.entity.AirlineEntity;
import com.project.finartz.entity.PlaneEntity;
import com.project.finartz.repository.AirlineRepository;
import com.project.finartz.repository.PlaneRepository;
import com.project.finartz.service.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlaneServiceImpl implements IPlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private DozerMapperUtility dozerMapperUtility;

    private static final String mapId = "PlaneEntity_Plane";

    @Override
    public List<Plane> fetchAllPlaneList() {
        List<PlaneEntity> planeEntityList = planeRepository.findAll();

        return dozerMapperUtility.map(planeEntityList, Plane.class, mapId);
    }

    @Override
    public Plane inquirePlaneById(Long planeId) {
        PlaneEntity planeEntity = planeRepository.findByPlaneId(planeId);

        return dozerMapperUtility.map(planeEntity, Plane.class, mapId);
    }

    @Override
    @Transactional
    public Plane createPlane(Plane plane) {
        PlaneEntity planeEntity = dozerMapperUtility.map(plane, PlaneEntity.class, mapId);
        planeRepository.save(planeEntity);

        return dozerMapperUtility.map(planeEntity, Plane.class, mapId);
    }

    @Override
    @Transactional
    public Plane updatePlane(Plane plane, Long planeId) {
        PlaneEntity planeEntity = planeRepository.findByPlaneId(planeId);
        planeEntity.setCapacity(plane.getCapacity());

        AirlineEntity airlineEntity = airlineRepository.findByAirlineId(plane.getAirline().getAirlineId());
        airlineEntity.setName(plane.getAirline().getName());
        planeEntity.setAirlineEntity(airlineEntity);

        planeRepository.save(planeEntity);

        return dozerMapperUtility.map(planeEntity, Plane.class, mapId);
    }

    @Override
    public Plane deletePlaneById(Long planeId) {
        PlaneEntity planeEntity = planeRepository.findByPlaneId(planeId);
        planeRepository.deleteById(planeId);

        return dozerMapperUtility.map(planeEntity, Plane.class, mapId);
    }
}
