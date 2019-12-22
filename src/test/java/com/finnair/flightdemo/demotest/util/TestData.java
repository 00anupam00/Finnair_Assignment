package com.finnair.flightdemo.demotest.util;

import com.finnair.flightdemo.demotest.dao.Booking;
import com.finnair.flightdemo.demotest.dao.Flight;
import com.finnair.flightdemo.demotest.dao.Passenger;
import com.finnair.flightdemo.demotest.dto.PassengerDetailsObj;
import com.finnair.flightdemo.demotest.dto.PassengerObj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestData {

    public PassengerDetailsObj getPassengerWithFlightDetailsData(){

        Set<Flight> flights= new HashSet<>();
        Flight flight= new Flight();
        flight.setFlightNumber("SVT4325");
        flight.setArrivalAirport("HQD");
        flight.setArrivalDate("2019-04-10");
        flight.setDepartureAirport("UML");
        flight.setDepartureDate("2019-07-25");
        flights.add(flight);

        PassengerDetailsObj passengerDetailsObj= new PassengerDetailsObj();
        passengerDetailsObj.setBookingId("YNBXDH");
        passengerDetailsObj.setEmail(null);
        passengerDetailsObj.setFirstName("Patrica");
        passengerDetailsObj.setLastName("Wink");
        passengerDetailsObj.setFlights(flights);

        return passengerDetailsObj;
    }

    public List<Passenger> getPassengerData(){

        Booking booking = new Booking();
        booking.setBookingId("YNBXDH");

        List<Passenger> passengerObjs= new ArrayList<>();
        Passenger passengerObj= new Passenger();
        passengerObj.setLastName("Wink");
        passengerObj.setFirstName("Patrica");
        passengerObj.setPassengerId("101844");
        passengerObj.setBooking(booking);
        passengerObjs.add(passengerObj);

        return passengerObjs;
    }

}
