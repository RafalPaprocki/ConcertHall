package com.ConcertHallWebApp.repository;

import com.ConcertHallWebApp.model.LoggingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggingDataRepository extends JpaRepository<LoggingData, Long> {
}
