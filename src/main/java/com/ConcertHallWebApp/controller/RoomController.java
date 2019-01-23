package com.ConcertHallWebApp.controller;

import com.ConcertHallWebApp.model.Room;
import com.ConcertHallWebApp.model.Seat;
import com.ConcertHallWebApp.repository.RoomRepository;
import com.ConcertHallWebApp.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/room/all")
    public Page<Room> getAllArticles(Pageable pageable){
        return roomRepository.findAll(pageable);
    }

    @GetMapping("/room/{roomId}")
    public List<Seat> getAllSeatsByRoomId(@PathVariable(value = "roomId") Long roomId) {
        return seatRepository.findByRoomId(roomId);
    }
}
