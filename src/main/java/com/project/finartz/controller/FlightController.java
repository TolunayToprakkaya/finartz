package com.project.finartz.controller;

import com.project.finartz.base.dto.Flight;
import com.project.finartz.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private IFlightService flightService;

    @GetMapping(value = "/fetchAllFlightList", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Flight>> fetchAllFlightList() {
        return new ResponseEntity<>(flightService.fetchAllFlightList(), HttpStatus.OK);
    }

    @GetMapping(value = "/inquireFlightById/{flightId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flight> inquireFlightById(@PathVariable("flightId") Long flightId) {
        return new ResponseEntity<>(flightService.inquireFlightById(flightId), HttpStatus.OK);
    }

    @PostMapping(value = "/createFlight", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        return new ResponseEntity<>(flightService.createFlight(flight), HttpStatus.OK);
    }

    @PutMapping(value = "/updateFlight/{flightId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight, @PathVariable("flightId") Long flightId) {
        return new ResponseEntity<>(flightService.updateFlight(flight, flightId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteFlightById/{flightId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flight> deleteFlightById(@PathVariable("flightId") Long flightId) {
        return new ResponseEntity<>(flightService.deleteFlightById(flightId), HttpStatus.OK);
    }
}
