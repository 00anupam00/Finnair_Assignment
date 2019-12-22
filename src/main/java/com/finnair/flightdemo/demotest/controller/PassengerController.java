package com.finnair.flightdemo.demotest.controller;

import com.finnair.flightdemo.demotest.dto.PassengerDetailsObj;
import com.finnair.flightdemo.demotest.dto.PassengerObj;
import com.finnair.flightdemo.demotest.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping(value = "/passengers", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<PassengerObj>> passengers(
            @RequestParam("flightNumber") String flightNumber,
            @RequestParam("departureDate") String departureDate){

        return ResponseEntity.ok(passengerService.getPassengerFlightBookingDetails(flightNumber, departureDate));
    }


    @GetMapping(value = "/passengers/{passengerId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<PassengerDetailsObj> passengersWithFlightDetails(
            @PathVariable("passengerId") String passengerId){

        return ResponseEntity.ok(passengerService.getPassengerObj(passengerId));
    }
}
