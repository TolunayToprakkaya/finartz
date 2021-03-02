package com.project.finartz.service.impl;

import com.project.finartz.base.dto.Ticket;
import com.project.finartz.base.mapper.DozerMapperUtility;
import com.project.finartz.entity.*;
import com.project.finartz.repository.*;
import com.project.finartz.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TicketServiceImpl implements ITicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    private DozerMapperUtility dozerMapperUtility;

    private static final String mapId = "TicketEntity_Ticket";

    @Override
    public List<Ticket> fetchAllTicketList() {
        List<TicketEntity> ticketEntityList = ticketRepository.findAll();

        return dozerMapperUtility.map(ticketEntityList, Ticket.class, mapId);
    }

    @Override
    public Ticket inquireTicketById(Long ticketId) {
        TicketEntity ticketEntity = ticketRepository.findByTicketId(ticketId);

        return dozerMapperUtility.map(ticketEntity, Ticket.class, mapId);
    }

    @Override
    @Transactional
    public Ticket createTicket(Ticket ticket) {
        this.updatePlaneCapacity(ticket);

        TicketEntity ticketEntity = dozerMapperUtility.map(ticket, TicketEntity.class, mapId);
        ticketRepository.save(ticketEntity);

        Ticket savedTicket = dozerMapperUtility.map(ticketEntity, Ticket.class, mapId);
        String maskedCreditCardInfo = this.maskifyUsingStreamGenerate(savedTicket.getCreditCardInfo());
        savedTicket.setCreditCardInfo(maskedCreditCardInfo);

        return savedTicket;
    }

    @Override
    @Transactional
    public Ticket updateTicket(Ticket ticket, Long ticketId) {
        TicketEntity ticketEntity = ticketRepository.findByTicketId(ticketId);
        ticketEntity.setPrice(ticket.getPrice());

        FlightEntity flightEntity = flightRepository.findByFlightId(ticket.getFlight().getFlightId());
        ticketEntity.setFlightEntity(flightEntity);

        CustomerEntity customerEntity = customerRepository.findByCustomerId(ticket.getCustomer().getCustomerId());
        ticketEntity.setCustomerEntity(customerEntity);

        ticketEntity.setCreditCardInfo(ticket.getCreditCardInfo());

        ticketRepository.save(ticketEntity);

        return dozerMapperUtility.map(ticketEntity, Ticket.class, mapId);
    }

    @Override
    public Ticket deleteTicketById(Long ticketId) {
        TicketEntity ticketEntity = ticketRepository.findByTicketId(ticketId);
        ticketRepository.deleteById(ticketId);

        return dozerMapperUtility.map(ticketEntity, Ticket.class, mapId);
    }

    private Ticket updatePlaneCapacity(Ticket ticket) {
        FlightEntity flightEntity = flightRepository.findByFlightId(ticket.getFlight().getFlightId());
        RouteEntity routeEntity = routeRepository.findByRouteId(flightEntity.getRouteEntity().getRouteId());
        PlaneEntity planeEntity = planeRepository.findByPlaneId(routeEntity.getPlaneEntity().getPlaneId());
        if (planeEntity.getCapacity() != 0) {
            planeEntity.setRemainder(planeEntity.getRemainder()-1);
            planeRepository.save(planeEntity);

            ticket.getFlight().getRoute().getPlane().setRemainder(planeEntity.getRemainder());
        }

        return ticket;
    }

    private String maskifyUsingStreamGenerate(String creditCard) {
        creditCard = creditCard.replaceAll("-", "");

        final int firstNonMaskedIndex = Math.max(0, creditCard.length() - 4);

        return Stream.generate(() -> "#")
                .limit(firstNonMaskedIndex)
                .collect(Collectors.joining())
                .concat(creditCard.substring(firstNonMaskedIndex));
    }
}
