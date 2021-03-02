package com.project.finartz.service;

import com.project.finartz.base.dto.Flight;

import java.util.List;

public interface IFlightService {

    List<Flight> fetchAllFlightList();

    Flight inquireFlightById(Long flightId);

    Flight createFlight(Flight flight);

    Flight updateFlight(Flight flight, Long flightId);

    Flight deleteFlightById(Long flightId);
}
