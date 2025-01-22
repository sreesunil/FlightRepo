package com.tekarch.TafFlightService.Services;

import com.tekarch.TafFlightService.Flight.Flight;

import java.util.List;

public interface FlightService {

    Flight createFlight(Flight flight);
    Flight getFlightById(Long id);
    List<Flight> getAllFlights();
    Flight updateFlight(Long id, Flight flight);
    void deleteFlight(Long id);
}
