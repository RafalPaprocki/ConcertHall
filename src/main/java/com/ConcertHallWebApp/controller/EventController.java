package com.ConcertHallWebApp.controller;

import com.ConcertHallWebApp.message.request.SignUpForm;
import com.ConcertHallWebApp.model.Event;
import com.ConcertHallWebApp.model.Room;
import com.ConcertHallWebApp.model.Ticket;
import com.ConcertHallWebApp.operations.ExcelGenerator;
import com.ConcertHallWebApp.operations.PDFGenerator;
import com.ConcertHallWebApp.repository.EventRepository;
import com.ConcertHallWebApp.repository.RoomRepository;
import com.ConcertHallWebApp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private TicketRepository ticketRepository;

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

    @GetMapping(value = "/pdf/ticket",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> customersReport(HttpServletResponse response) throws IOException {
        List<Ticket> customers = (List<Ticket>) ticketRepository.findAll();

        ByteArrayInputStream bis = PDFGenerator.customerPDFReport(customers);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=customers.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "/download/customers.xlsx")
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
        List<Event> customers = (List<Event>) eventRepository.findAll();

        ByteArrayInputStream in = ExcelGenerator.customersToExcel(customers);
        // return IOUtils.toByteArray(in);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=customers.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
}
