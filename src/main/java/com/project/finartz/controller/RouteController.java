package com.project.finartz.controller;

import com.project.finartz.base.dto.Route;
import com.project.finartz.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private IRouteService routeService;

    @GetMapping(value = "/fetchAllRouteList", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Route>> fetchAllRouteList() {
        return new ResponseEntity<>(routeService.fetchAllRouteList(), HttpStatus.OK);
    }

    @GetMapping(value = "/inquireRouteById/{routeId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Route> inquireRouteById(@PathVariable("routeId") Long routeId) {
        return new ResponseEntity<>(routeService.inquireRouteById(routeId), HttpStatus.OK);
    }

    @PostMapping(value = "/createRoute", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Route> createRoute(@RequestBody Route route) {
        return new ResponseEntity<>(routeService.createRoute(route), HttpStatus.OK);
    }

    @PutMapping(value = "/updateRoute/{routeId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Route> updateRoute(@RequestBody Route route, @PathVariable("routeId") Long routeId) {
        return new ResponseEntity<>(routeService.updateRoute(route, routeId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteRouteById/{routeId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Route> deleteRouteById(@PathVariable("routeId") Long routeId) {
        return new ResponseEntity<>(routeService.deleteRouteById(routeId), HttpStatus.OK);
    }
}
