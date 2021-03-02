package com.project.finartz.entity;

import com.project.finartz.base.type.AbstractEditableEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "airport")
public class AirportEntity extends AbstractEditableEntity {

    @Id
    @Column(name = "airport_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airportId;

    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "airportEntityDeparturePlace")
    private Set<RouteEntity> routeEntityDeparturePlaceSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "airportEntityLandingPlace")
    private Set<RouteEntity> routeEntityLandingPlaceSet = new HashSet<>();

    public Long getAirportId() {
        return airportId;
    }

    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RouteEntity> getRouteEntityDeparturePlaceSet() {
        return routeEntityDeparturePlaceSet;
    }

    public void setRouteEntityDeparturePlaceSet(Set<RouteEntity> routeEntityDeparturePlaceSet) {
        this.routeEntityDeparturePlaceSet = routeEntityDeparturePlaceSet;
    }

    public Set<RouteEntity> getRouteEntityLandingPlaceSet() {
        return routeEntityLandingPlaceSet;
    }

    public void setRouteEntityLandingPlaceSet(Set<RouteEntity> routeEntityLandingPlaceSet) {
        this.routeEntityLandingPlaceSet = routeEntityLandingPlaceSet;
    }
}
