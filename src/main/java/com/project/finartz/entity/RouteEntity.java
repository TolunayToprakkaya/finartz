package com.project.finartz.entity;

import com.project.finartz.base.type.AbstractEditableEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "route")
public class RouteEntity extends AbstractEditableEntity {

    @Id
    @Column(name = "route_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "departure_time")
    private Timestamp departureTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_id", nullable = false)
    private PlaneEntity planeEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_place_id", nullable = false)
    private AirportEntity airportEntityDeparturePlace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landing_place_id", nullable = false)
    private AirportEntity airportEntityLandingPlace;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "routeEntity")
    private Set<FlightEntity> flightEntitySet = new HashSet<>();

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

    public PlaneEntity getPlaneEntity() {
        return planeEntity;
    }

    public void setPlaneEntity(PlaneEntity planeEntity) {
        this.planeEntity = planeEntity;
    }

    public AirportEntity getAirportEntityDeparturePlace() {
        return airportEntityDeparturePlace;
    }

    public void setAirportEntityDeparturePlace(AirportEntity airportEntityDeparturePlace) {
        this.airportEntityDeparturePlace = airportEntityDeparturePlace;
    }

    public AirportEntity getAirportEntityLandingPlace() {
        return airportEntityLandingPlace;
    }

    public void setAirportEntityLandingPlace(AirportEntity airportEntityLandingPlace) {
        this.airportEntityLandingPlace = airportEntityLandingPlace;
    }

    public Set<FlightEntity> getFlightEntitySet() {
        return flightEntitySet;
    }

    public void setFlightEntitySet(Set<FlightEntity> flightEntitySet) {
        this.flightEntitySet = flightEntitySet;
    }
}
