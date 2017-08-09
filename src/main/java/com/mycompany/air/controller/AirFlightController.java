package com.mycompany.air.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.air.model.AirFlightRequest;
import com.mycompany.air.model.AirFlightResponse;
import com.mycompany.air.service.AirFlightService;

@RestController
@RequestMapping("/flight")
public class AirFlightController {

  final static Logger LOGGER = Logger.getLogger(AirFlightController.class);

  private final AirFlightService airFlightService;

  @Autowired
  public AirFlightController(final AirFlightService airFlightService) {
    this.airFlightService = airFlightService;
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AirFlightResponse> addFlight(@RequestBody final AirFlightResponse airFlightResponse) {
    airFlightService.saveFlight(airFlightResponse);
    LOGGER.debug("Added: " + airFlightResponse);

    return new ResponseEntity<AirFlightResponse>(airFlightResponse, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/searchCriteria", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<AirFlightResponse>> getFlightByRequest(
                  @RequestBody final AirFlightRequest airFlightRequest) {

    List<AirFlightResponse> airFlightResponses = airFlightService.getFlightByRequest(airFlightRequest);
    if (airFlightResponses.isEmpty()) {
      LOGGER.debug("AirFlightResponse does not exists");
      return new ResponseEntity<List<AirFlightResponse>>(HttpStatus.NO_CONTENT);
    } else {
      LOGGER.debug("Found " + airFlightResponses.size() + " Flights");
      LOGGER.debug(airFlightResponses);
      LOGGER.debug(Arrays.toString(airFlightResponses.toArray()));
    }

    return new ResponseEntity<List<AirFlightResponse>>(airFlightResponses, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<AirFlightResponse>> getAllFlights() {

    List<AirFlightResponse> airFlightResponses = airFlightService.getAllAirFlights();
    if (airFlightResponses.isEmpty()) {
      LOGGER.debug("AirFlightResponse does not exists");
      return new ResponseEntity<List<AirFlightResponse>>(HttpStatus.NO_CONTENT);
    } else {
      LOGGER.debug("Found " + airFlightResponses.size() + " Flights");
      LOGGER.debug(airFlightResponses);
      LOGGER.debug(Arrays.toString(airFlightResponses.toArray()));
    }

    return new ResponseEntity<List<AirFlightResponse>>(airFlightResponses, HttpStatus.OK);
  }

}
