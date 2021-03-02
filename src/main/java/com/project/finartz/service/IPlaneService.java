package com.project.finartz.service;

import com.project.finartz.base.dto.Plane;

import java.util.List;

public interface IPlaneService {

    List<Plane> fetchAllPlaneList();

    Plane inquirePlaneById(Long planeId);

    Plane createPlane(Plane plane);

    Plane updatePlane(Plane plane, Long planeId);

    Plane deletePlaneById(Long planeId);
}
