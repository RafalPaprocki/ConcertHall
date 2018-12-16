package com.ConcertHallWebApp.controller;

import com.ConcertHallWebApp.model.Event;
import com.ConcertHallWebApp.model.LoggingData;
import com.ConcertHallWebApp.model.Room;
import com.ConcertHallWebApp.repository.EventRepository;
import com.ConcertHallWebApp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/event/all")
    public Page<Event> getAllCustomers(Pageable pageable){
        return eventRepository.findAll(pageable);
    }

    @GetMapping("/event/room/{roomId}")
    public Page<Event> getAllEventsInRoom(Pageable pageable, @PathVariable(value = "roomId") Long roomId){
        return eventRepository.findByRoomId(roomId, pageable);
    }

}
