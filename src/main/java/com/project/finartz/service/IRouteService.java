package com.project.finartz.service;

import com.project.finartz.base.dto.Route;

import java.util.List;

public interface IRouteService {

    List<Route> fetchAllRouteList();

    Route inquireRouteById(Long routeId);

    Route createRoute(Route route);

    Route updateRoute(Route route, Long routeId);

    Route deleteRouteById(Long routeId);
}
