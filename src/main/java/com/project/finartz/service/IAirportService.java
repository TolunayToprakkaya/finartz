package com.project.finartz.service;

import com.project.finartz.base.dto.Airport;

import java.util.List;

public interface IAirportService {

    List<Airport> fetchAllAirportList();

    Airport inquireAirportById(Long airportId);

    Airport createAirport(Airport airport);

    Airport updateAirport(Airport airport, Long airportId);

    Airport deleteAirportById(Long airportId);
}
