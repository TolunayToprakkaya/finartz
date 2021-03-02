package com.project.finartz.controller;

import com.project.finartz.base.dto.Airport;
import com.project.finartz.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private IAirportService airportService;

    @GetMapping(value = "/fetchAllAirportList", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Airport>> fetchAllAirportList() {
        return new ResponseEntity<>(airportService.fetchAllAirportList(), HttpStatus.OK);
    }

    @GetMapping(value = "/inquireAirportById/{airportId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Airport> inquireAirportById(@PathVariable("airportId") Long airportId) {
        return new ResponseEntity<>(airportService.inquireAirportById(airportId), HttpStatus.OK);
    }

    @PostMapping(value = "/createAirport", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        return new ResponseEntity<>(airportService.createAirport(airport), HttpStatus.OK);
    }

    @PutMapping(value = "/updateAirport/{airportId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Airport> updateAirport(@RequestBody Airport airport, @PathVariable("airportId") Long airportId) {
        return new ResponseEntity<>(airportService.updateAirport(airport, airportId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteAirportById/{airportId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Airport> deleteAirportById(@PathVariable("airportId") Long airportId) {
        return new ResponseEntity<>(airportService.deleteAirportById(airportId), HttpStatus.OK);
    }
}
