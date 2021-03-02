package com.project.finartz.service;

import com.project.finartz.base.dto.Airline;

import java.util.List;

public interface IAirlineService {

    List<Airline> fetchAllAirlineList();

    Airline inquireAirlineById(Long airlineId);

    Airline createAirline(Airline airline);

    Airline updateAirline(Airline airline, Long airlineId);

    Airline deleteAirlineById(Long airlineId);
}
