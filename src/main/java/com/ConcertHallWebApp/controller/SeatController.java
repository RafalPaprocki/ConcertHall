package com.ConcertHallWebApp.controller;

import com.ConcertHallWebApp.model.Seat;
import com.ConcertHallWebApp.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/seat/all")
    public List<Seat> getAllCustomers(Pageable pageable){
        return seatRepository.findByOccupied(false);
    }

}
