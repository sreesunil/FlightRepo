package com.tekarch.TafFlightService.Services;


import com.tekarch.TafFlightService.Flight.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${datastore.service.url}")
    String datastoreServiceUrl;


    @Override
    public Flight createFlight(Flight flight) {
        return restTemplate.postForObject(datastoreServiceUrl , flight , Flight.class);
    }

    @Override
    public Flight getFlightById(Long id) {
        return restTemplate.getForObject(datastoreServiceUrl + "/" + id, Flight.class);
    }

    @Override
    public List<Flight> getAllFlights() {
        return Arrays.asList(restTemplate.getForObject(datastoreServiceUrl, Flight[].class));
    }

    @Override
    public Flight updateFlight(Long id, Flight flight) {
        restTemplate.put(datastoreServiceUrl + "/" + id, flight);
        return flight;
    }

    @Override
    public void deleteFlight(Long id) {
        restTemplate.delete(datastoreServiceUrl + "/" + id);
    }
}
