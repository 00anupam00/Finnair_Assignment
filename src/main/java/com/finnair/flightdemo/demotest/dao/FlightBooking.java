package com.finnair.flightdemo.demotest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "flight_booking")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightBooking implements Serializable {

    @Id
    @Column(name = "flight_number")
    private String flightNumber;

    @Id
    @Column(name = "booking_id", length = 6)
    private String bookingId;
}
