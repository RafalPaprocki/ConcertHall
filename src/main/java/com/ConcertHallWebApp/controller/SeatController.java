package com.ConcertHallWebApp.controller;

import com.ConcertHallWebApp.model.Employee;
import com.ConcertHallWebApp.model.Seat;
import com.ConcertHallWebApp.repository.EmployeeRepository;
import com.ConcertHallWebApp.repository.LoggingDataRepository;
import com.ConcertHallWebApp.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/seat/all")
    public Page<Seat> getAllCustomers(Pageable pageable){
        return seatRepository.findAll(pageable);
    }

}
