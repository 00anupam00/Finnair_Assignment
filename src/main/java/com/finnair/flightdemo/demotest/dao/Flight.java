package com.finnair.flightdemo.demotest.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "flight")
@Getter @Setter @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Flight {

    @Id
    @Column
    private String flightNumber; //carrier code + flight number.

    @Column(length = 3)
    private String departureAirport;

    @Column(length = 3)
    private String arrivalAirport;

    @Column
    private String departureDate; //yyyy-mm-dd

    @Column
    private String arrivalDate;

    @ManyToMany(mappedBy = "flights")
    @JsonIgnore
    private Set<Booking> booking;
}
