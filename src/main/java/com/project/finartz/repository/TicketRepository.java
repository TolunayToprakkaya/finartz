package com.project.finartz.repository;

import com.project.finartz.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {

    TicketEntity findByTicketId(Long ticketId);
}
