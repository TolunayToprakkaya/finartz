package com.project.finartz.entity;

import com.project.finartz.base.type.AbstractEditableEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "customer")
public class CustomerEntity extends AbstractEditableEntity {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @Basic
    @Column(name = "age")
    private Long age;

    @Basic
    @Column(name = "gender")
    private String gender;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customerEntity")
    private Set<TicketEntity> ticketEntitySet = new HashSet<>();

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<TicketEntity> getTicketEntitySet() {
        return ticketEntitySet;
    }

    public void setTicketEntitySet(Set<TicketEntity> ticketEntitySet) {
        this.ticketEntitySet = ticketEntitySet;
    }
}
