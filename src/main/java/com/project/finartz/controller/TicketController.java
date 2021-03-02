package com.project.finartz.controller;

import com.project.finartz.base.dto.Ticket;
import com.project.finartz.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private ITicketService ticketService;

    @GetMapping(value = "/fetchAllTicketList", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ticket>> fetchAllTicketList() {
        return new ResponseEntity<>(ticketService.fetchAllTicketList(), HttpStatus.OK);
    }

    @GetMapping(value = "/inquireTicketById/{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> inquireTicketById(@PathVariable("ticketId") Long ticketId) {
        return new ResponseEntity<>(ticketService.inquireTicketById(ticketId), HttpStatus.OK);
    }

    @PostMapping(value = "/createTicket", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return new ResponseEntity<>(ticketService.createTicket(ticket), HttpStatus.OK);
    }

    @PutMapping(value = "/updateTicket/{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket, @PathVariable("ticketId") Long ticketId) {
        return new ResponseEntity<>(ticketService.updateTicket(ticket, ticketId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteTicketById/{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> deleteTicketById(@PathVariable("ticketId") Long ticketId) {
        return new ResponseEntity<>(ticketService.deleteTicketById(ticketId), HttpStatus.OK);
    }
}
