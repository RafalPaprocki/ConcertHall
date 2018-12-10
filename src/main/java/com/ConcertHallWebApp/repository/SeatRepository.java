package com.ConcertHallWebApp.repository;

import com.ConcertHallWebApp.model.Seat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    Page<Seat> findByRoomId(Long seatId, Pageable pageable);
}
