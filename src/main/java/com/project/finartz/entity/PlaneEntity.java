package com.project.finartz.entity;

import com.project.finartz.base.type.AbstractEditableEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "plane")
public class PlaneEntity extends AbstractEditableEntity {

    @Id
    @Column(name = "plane_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planeId;

    @Basic
    @Column(name = "capacity")
    private Long capacity;

    @Basic
    @Column(name = "remainder")
    private Long remainder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable = false)
    private AirlineEntity airlineEntity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "planeEntity")
    private Set<RouteEntity> routeEntitySet = new HashSet<>();

    public Long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Long planeId) {
        this.planeId = planeId;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Long getRemainder() {
        return remainder;
    }

    public void setRemainder(Long remainder) {
        this.remainder = remainder;
    }

    public AirlineEntity getAirlineEntity() {
        return airlineEntity;
    }

    public void setAirlineEntity(AirlineEntity airlineEntity) {
        this.airlineEntity = airlineEntity;
    }

    public Set<RouteEntity> getRouteEntitySet() {
        return routeEntitySet;
    }

    public void setRouteEntitySet(Set<RouteEntity> routeEntitySet) {
        this.routeEntitySet = routeEntitySet;
    }
}
