package com.ConcertHallWebApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String Surname;

    @NotNull
    private String name;

    @NotNull
    private String position;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "loggingData_id", nullable = false)
    @NotNull
    private LoggingData loggingData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public LoggingData getLoggingData() {
        return loggingData;
    }

    public void setLoggingData(LoggingData loggingData) {
        this.loggingData = loggingData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
