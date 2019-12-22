package com.finnair.flightdemo.demotest.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "booking")
@Getter @Setter @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking implements Serializable {

    @Id
    @Column(length = 6)
    private String bookingId;

    @OneToMany(mappedBy = "booking",fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("booking")
    private Set<Passenger> passengers;

    @ManyToMany
    @JoinTable(
            name = "flight_booking",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_number")
    )
    @JsonIgnoreProperties("booking")
    private Set<Flight> flights;
}
