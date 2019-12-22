package com.finnair.flightdemo.demotest.service;

import com.finnair.flightdemo.demotest.dao.Passenger;
import com.finnair.flightdemo.demotest.dto.PassengerDetailsObj;
import com.finnair.flightdemo.demotest.dto.PassengerObj;
import com.finnair.flightdemo.demotest.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<PassengerObj> getPassengerFlightBookingDetails(String flightNumber, String departureDate){
        List<Passenger> passengers= passengerRepository.
                getPassengersByFlightDetails(flightNumber, departureDate);

        List<PassengerObj> passengerObjs= new ArrayList<>();
        passengers.forEach(
                passenger -> {
                    PassengerObj passObj= new PassengerObj();
                    passObj.setFirstName(passenger.getFirstName());
                    passObj.setLastName(passenger.getLastName());
                    passObj.setPassengerId(passenger.getPassengerId());
                    passObj.setBookingId(passenger.getPassengerId());
                    passengerObjs.add(passObj);
                }
        );
        return passengerObjs;
    }

    public PassengerDetailsObj getPassengerObj(String passengerId){
        Passenger passenger= passengerRepository.getPassengerByPassengerId(passengerId)
                .orElseThrow(NoSuchElementException::new);
        PassengerDetailsObj passengerDetailsObj= new PassengerDetailsObj();
        passengerDetailsObj.setBookingId(passenger.getBooking().getBookingId());
        passengerDetailsObj.setPassengerId(passenger.getPassengerId());
        passengerDetailsObj.setFirstName(passenger.getFirstName());
        passengerDetailsObj.setLastName(passenger.getLastName());
        passengerDetailsObj.setFlights(passenger.getBooking().getFlights());
        return passengerDetailsObj;
    }
}
