package com.ConcertHallWebApp.controller;

import com.ConcertHallWebApp.model.Room;
import com.ConcertHallWebApp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/room/all")
    public Page<Room> getAllArticles(Pageable pageable){
        return roomRepository.findAll(pageable);
    }

}
