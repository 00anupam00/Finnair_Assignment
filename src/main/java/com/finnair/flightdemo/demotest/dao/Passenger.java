package com.finnair.flightdemo.demotest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "passenger")
@Getter @Setter @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Passenger {

    @Id
    @Column
    private String passengerId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @ManyToOne(targetEntity = Booking.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("passenger")
    private Booking booking;
}
