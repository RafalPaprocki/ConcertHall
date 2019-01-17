package com.ConcertHallWebApp.controller;

import com.ConcertHallWebApp.message.request.SignUpForm;
import com.ConcertHallWebApp.model.Event;
import com.ConcertHallWebApp.model.Room;
import com.ConcertHallWebApp.repository.EventRepository;
import com.ConcertHallWebApp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/event/all")
    public List<Event> getAllEvent(){
        return eventRepository.findAll();
    }

    @GetMapping("/event/room/{roomId}")
    public Page<Event> getAllEventsInRoom(Pageable pageable, @PathVariable(value = "roomId") Long roomId){
        return eventRepository.findByRoomId(roomId, pageable);
    }

    @PostMapping("/event/add/{roomId}")
    public Event addEvent(@PathVariable(value= "roomId") Long roomId, @Valid @RequestBody Event event){
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Nie znaleziono rooma"));
        event.setRoom(room);
        Event e = eventRepository.save(event);
        return e;
    }
}
