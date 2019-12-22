package com.finnair.flightdemo.demotest.repository;

import com.finnair.flightdemo.demotest.dao.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

    Optional<Passenger> getPassengerByPassengerId(String passengerId);

    @Query("Select p from passenger p where p.booking.bookingId in " +
            "(select fb.bookingId from flight_booking fb where fb.flightNumber in " +
            "(select f.flightNumber from flight f " +
            "where f.flightNumber = :flightNumber and f.departureDate = :departureDate)) ")
    List<Passenger> getPassengersByFlightDetails(@Param("flightNumber") String flightNumber,
                                                 @Param("departureDate") String departureDate);

}
