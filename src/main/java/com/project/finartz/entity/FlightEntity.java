package com.project.finartz.entity;

import com.project.finartz.base.type.AbstractEditableEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "flight")
public class FlightEntity extends AbstractEditableEntity {

    @Id
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @Basic
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private RouteEntity routeEntity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "flightEntity")
    private Set<TicketEntity> ticketEntitySet = new HashSet<>();

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RouteEntity getRouteEntity() {
        return routeEntity;
    }

    public void setRouteEntity(RouteEntity routeEntity) {
        this.routeEntity = routeEntity;
    }

    public Set<TicketEntity> getTicketEntitySet() {
        return ticketEntitySet;
    }

    public void setTicketEntitySet(Set<TicketEntity> ticketEntitySet) {
        this.ticketEntitySet = ticketEntitySet;
    }
}
