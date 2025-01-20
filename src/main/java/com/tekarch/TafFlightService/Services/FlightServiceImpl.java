package com.tekarch.TafFlightService.Services;


import com.tekarch.TafFlightService.DTO.FlightDTO;
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
    public FlightDTO createFlight(FlightDTO flightDTO) {
        return restTemplate.postForObject(datastoreServiceUrl , flightDTO ,FlightDTO.class);
    }

    @Override
    public FlightDTO getFlightById(Long id) {
        return restTemplate.getForObject(datastoreServiceUrl , FlightDTO.class);
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        FlightDTO[] flightsArray = restTemplate.getForObject(datastoreServiceUrl , FlightDTO[].class);
        return Arrays.asList(flightsArray);
    }

    @Override
    public FlightDTO updateFlight(Long id, FlightDTO flightDTO) {
         restTemplate.put(datastoreServiceUrl ,flightDTO, FlightDTO.class);
        return flightDTO;
    }

    @Override
    public void deleteFlight(Long id) {
        restTemplate.delete(datastoreServiceUrl , id);

    }
}
