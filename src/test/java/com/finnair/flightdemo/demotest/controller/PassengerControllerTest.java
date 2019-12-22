package com.finnair.flightdemo.demotest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finnair.flightdemo.demotest.DemoTestApplication;
import com.finnair.flightdemo.demotest.repository.PassengerRepository;
import com.finnair.flightdemo.demotest.service.PassengerService;
import com.finnair.flightdemo.demotest.util.TestData;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@Import({PassengerService.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = DemoTestApplication.class
)
@AutoConfigureMockMvc
public class PassengerControllerTest extends TestData {

    @Autowired
    private MockMvc mockClient;

    private ObjectMapper objectMapper;

    @MockBean
    private PassengerRepository passengerRepository;

    @BeforeEach
    void setUp() {
        this.objectMapper= new ObjectMapper();
    }

    @Test
    public void testPassengers() throws Exception {
        Mockito.when(passengerRepository.getPassengersByFlightDetails(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(getPassengerData());
        mockClient.perform(MockMvcRequestBuilders
                .get("/passengers")
                .queryParam("flightNumber","SVT4325")
                .queryParam("departureDate","2019-07-25")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].passengerId").exists())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testPassengersWithFlightDetails() throws Exception {
        Mockito.when(passengerRepository.getPassengerByPassengerId(Mockito.anyString()))
                .thenReturn(java.util.Optional.ofNullable(getPassengerData().get(0)));
        mockClient.perform(MockMvcRequestBuilders
                .get("/passengers/101844")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.passengerId").exists())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }
}