package com.project.finartz.controller;

import com.project.finartz.base.dto.Airline;
import com.project.finartz.service.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private IAirlineService airlineService;

    @GetMapping(value = "/fetchAllAirlineList", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Airline>> fetchAllAirlineList() {
        return new ResponseEntity<>(airlineService.fetchAllAirlineList(), HttpStatus.OK);
    }

    @GetMapping(value = "/inquireAirlineById/{airlineId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Airline> inquireAirlineById(@PathVariable("airlineId") Long airlineId) {
        return new ResponseEntity<>(airlineService.inquireAirlineById(airlineId), HttpStatus.OK);
    }

    @PostMapping(value = "/createAirline", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Airline> createAirline(@RequestBody Airline airline) {
        return new ResponseEntity<>(airlineService.createAirline(airline), HttpStatus.OK);
    }

    @PutMapping(value = "/updateAirline/{airlineId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Airline> updateAirline(@RequestBody Airline airline, @PathVariable("airlineId") Long airlineId) {
        return new ResponseEntity<>(airlineService.updateAirline(airline, airlineId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteAirlineById/{airlineId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Airline> deleteAirlineById(@PathVariable("airlineId") Long airlineId) {
        return new ResponseEntity<>(airlineService.deleteAirlineById(airlineId), HttpStatus.OK);
    }
}
