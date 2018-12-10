package com.ConcertHallWebApp.controller;

import com.ConcertHallWebApp.Exceptions.ResourceNotFoundException;
import com.ConcertHallWebApp.model.Customer;
import com.ConcertHallWebApp.model.LoggingData;
import com.ConcertHallWebApp.model.Room;
import com.ConcertHallWebApp.repository.CustomerRepository;
import com.ConcertHallWebApp.repository.LoggingDataRepository;
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
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoggingDataRepository loggingDataRepository;

    @GetMapping("/customer/all")
    public Page<Customer> getAllCustomers(Pageable pageable){
        return customerRepository.findAll(pageable);
    }

    @GetMapping("/customer/{customerId}/loggingData")
    public LoggingData loggingDataByCustomerId(@PathVariable(value = "customerId") Long customerId){
        return customerRepository.findById(customerId).map(customer -> {
            return customer.getLoggingData();
        }).orElseThrow(() -> new ResourceNotFoundException("CompartmentId "  + customerId + " not found"));
    }
}
