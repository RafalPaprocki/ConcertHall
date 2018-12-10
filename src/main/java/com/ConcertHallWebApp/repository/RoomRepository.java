package com.ConcertHallWebApp.repository;

import com.ConcertHallWebApp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository  extends JpaRepository<Room, Long> {
}
