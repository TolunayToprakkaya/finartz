package com.project.finartz.controller;

import com.project.finartz.base.dto.Plane;
import com.project.finartz.service.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plane")
public class PlaneController {

    @Autowired
    private IPlaneService planeService;

    @GetMapping(value = "/fetchAllPlaneList", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Plane>> fetchAllPlaneList() {
        return new ResponseEntity<>(planeService.fetchAllPlaneList(), HttpStatus.OK);
    }

    @GetMapping(value = "/inquirePlaneById/{planeId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plane> inquirePlaneById(@PathVariable("planeId") Long planeId) {
        return new ResponseEntity<>(planeService.inquirePlaneById(planeId), HttpStatus.OK);
    }

    @PostMapping(value = "/createPlane", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plane> createPlane(@RequestBody Plane plane) {
        return new ResponseEntity<>(planeService.createPlane(plane), HttpStatus.OK);
    }

    @PutMapping(value = "/updatePlane/{planeId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plane> updatePlane(@RequestBody Plane plane, @PathVariable("planeId") Long planeId) {
        return new ResponseEntity<>(planeService.updatePlane(plane, planeId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletePlaneById/{planeId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plane> deletePlaneById(@PathVariable("planeId") Long planeId) {
        return new ResponseEntity<>(planeService.deletePlaneById(planeId), HttpStatus.OK);
    }
}
