package com.finnair.flightdemo.demotest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.finnair.flightdemo.demotest.dao.Flight;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PassengerDetailsObj {

    private String passengerId;
    private String firstName;
    private String lastName;
    private String email;
    private String bookingId;
    private Set<Flight> flights;
}
