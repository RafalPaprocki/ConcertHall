package com.ConcertHallWebApp.repository;

import com.ConcertHallWebApp.model.Event;
import com.ConcertHallWebApp.model.Seat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Page<Event> findByRoomId(Long roomId, Pageable pageable);
}
