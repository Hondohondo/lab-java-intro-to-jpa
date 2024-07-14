package com.ironhack.JPA.Assignment.repository;

import com.ironhack.JPA.Assignment.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Optional<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findAllByFlightMileageGreaterThan(Integer mileage);
    List<Flight> findAllByAircraftContaining(String aircraft);


}
