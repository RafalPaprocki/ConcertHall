package com.ConcertHallWebApp.controller;

import com.ConcertHallWebApp.model.Customer;
import com.ConcertHallWebApp.model.Employee;
import com.ConcertHallWebApp.repository.CustomerRepository;
import com.ConcertHallWebApp.repository.EmployeeRepository;
import com.ConcertHallWebApp.repository.LoggingDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeControler {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LoggingDataRepository loggingDataRepository;

    @GetMapping("/employee/all")
    public Page<Employee> getAllCustomers(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }

}
