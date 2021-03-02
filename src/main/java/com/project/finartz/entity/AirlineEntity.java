package com.project.finartz.entity;

import com.project.finartz.base.type.AbstractEditableEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "airline")
public class AirlineEntity extends AbstractEditableEntity {

    @Id
    @Column(name = "airlineId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airlineId;

    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "airlineEntity")
    private Set<PlaneEntity> planeEntitySet = new HashSet<>();

    public Long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Long airlineId) {
        this.airlineId = airlineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PlaneEntity> getPlaneEntitySet() {
        return planeEntitySet;
    }

    public void setPlaneEntitySet(Set<PlaneEntity> planeEntitySet) {
        this.planeEntitySet = planeEntitySet;
    }
}
