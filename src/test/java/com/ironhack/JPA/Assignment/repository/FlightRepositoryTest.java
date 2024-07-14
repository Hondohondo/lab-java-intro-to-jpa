package com.ironhack.JPA.Assignment.repository;

import com.ironhack.JPA.Assignment.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {
    @Autowired
    private FlightRepository flightRepository;

    Flight flight;

    @BeforeEach
    void setUp() {
        flight = new Flight("H0097","Bombardier 97", 240,9700);
        flightRepository.save(flight);
    }

    @AfterEach
    void tearDown() {
//        flightRepository.deleteById(Flight.getFlightId());
        flightRepository.deleteById(flight.getFlightId());
    }

    @Test
    public void findAll_flights_flightList() {
        List<Flight> flightList = flightRepository.findAll();
        System.out.println(flightList);
        assertEquals(6, flightList.size());

    }

    @Test
    public void findById_validId_correctFlight() {
        Optional<Flight> flightOptional = flightRepository.findById(4);
        assertTrue(flightOptional.isPresent());
        System.out.println(flightOptional.get());
        assertEquals("Embraer E175", flightOptional.get().getAircraft());
    }

    @Test
    public void findById_invalidId_flightNotPresent() {
        Optional<Flight> flightOptional = flightRepository.findById(10);
        assertTrue(flightOptional.isEmpty());
    }

    @Test
    public void findByFlightNumber_validFlightNumber_correctFlight() {
        Optional<Flight> flight = flightRepository.findByFlightNumber("ZQ789");
        assertTrue(flight.isPresent());
        System.out.println(flight.get());
    }

    @Test
    public void findAllByFlightMileageGreaterThan_validFlightMileage_flightList() {
        List<Flight> flightList = flightRepository.findAllByFlightMileageGreaterThan(500);
        System.out.println(flightList);
        assertEquals(6, flightList.size());

//        flightList.get(2).getFlightNumber();
//        System.out.println(flight);
    }

    @Test
    public void findAllByAircraftContaining_validAircraft_flightList() {
        List<Flight> flightList = flightRepository.findAllByAircraftContaining("Boeing");
        System.out.println(flightList);
        assertEquals(1, flightList.size());
    }





}