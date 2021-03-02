package com.project.finartz.base.dto;

import java.sql.Timestamp;

public class Route {

    private Long routeId;
    private String name;
    private Timestamp departureTime;
    private Plane plane;
    private Airport airportDeparturePlace;
    private Airport airportLandingPlace;

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Airport getAirportDeparturePlace() {
        return airportDeparturePlace;
    }

    public void setAirportDeparturePlace(Airport airportDeparturePlace) {
        this.airportDeparturePlace = airportDeparturePlace;
    }

    public Airport getAirportLandingPlace() {
        return airportLandingPlace;
    }

    public void setAirportLandingPlace(Airport airportLandingPlace) {
        this.airportLandingPlace = airportLandingPlace;
    }
}
