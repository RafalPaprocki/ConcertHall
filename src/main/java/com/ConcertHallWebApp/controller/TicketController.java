package com.ConcertHallWebApp.controller;

import com.ConcertHallWebApp.message.request.TicketAddBody;
import com.ConcertHallWebApp.model.*;
import com.ConcertHallWebApp.repository.EventRepository;
import com.ConcertHallWebApp.repository.SeatRepository;
import com.ConcertHallWebApp.repository.TicketRepository;
import com.ConcertHallWebApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TicketController {

    @Autowired
    public TicketRepository ticketRepository;

    @Autowired
    public EventRepository eventRepository;

    @Autowired
    public SeatRepository seatRepository;

    @Autowired
    public UserRepository userRepository;

    @PostMapping("/ticket")
    public Ticket addTicket(@Valid @RequestBody TicketAddBody body){
        Event event = eventRepository.findById(body.getEvent_id()).orElseThrow(() -> new RuntimeException("Nie znaleziono wydarzenia"));
        Seat seat = seatRepository.findById(body.getSeat_id()).orElseThrow(() -> new RuntimeException("Nie znaleziono miejsca"));
        User user = userRepository.findById(body.getUser_id()).orElseThrow(() -> new RuntimeException(("Nie znaleziono użytkownika")));

        Ticket ticket = new Ticket();
        ticket.setPrice(body.getPrice());
        ticket.setEvent(event);
        ticket.setSeat(seat);
        ticket.setUser(user);

        return ticketRepository.save(ticket);
    }
}
