package com.ConcertHallWebApp.repository;

import com.ConcertHallWebApp.model.Seat;
import com.ConcertHallWebApp.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
