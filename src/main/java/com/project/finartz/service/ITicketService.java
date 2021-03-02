package com.project.finartz.service;

import com.project.finartz.base.dto.Ticket;

import java.util.List;

public interface ITicketService {

    List<Ticket> fetchAllTicketList();

    Ticket inquireTicketById(Long ticketId);

    Ticket createTicket(Ticket ticket);

    Ticket updateTicket(Ticket ticket, Long ticketId);

    Ticket deleteTicketById(Long ticketId);
}
