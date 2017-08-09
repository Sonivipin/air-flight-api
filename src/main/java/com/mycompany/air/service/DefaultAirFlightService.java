package com.mycompany.air.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.air.model.AirFlightRequest;
import com.mycompany.air.model.AirFlightResponse;
import com.mycompany.air.repository.AirFlightRepository;

/**
 * 
 * This class is used to implement all crude operations.
 *
 */
@Service
public class DefaultAirFlightService implements AirFlightService {

  private final AirFlightRepository airFlightRepository;

  @Autowired
  public DefaultAirFlightService(final AirFlightRepository airFlightRepository) {
    this.airFlightRepository = airFlightRepository;
  }

  @Override
  public AirFlightResponse saveFlight(final AirFlightResponse entity) {
    return airFlightRepository.save(entity);
  }

  @Override
  public List<AirFlightResponse> getAllAirFlights() {
    return airFlightRepository.findAll();
  }

  @Override
  public void deleteFlight(Serializable id) {
    airFlightRepository.delete((Long) id);
  }

  @Override
  public List<AirFlightResponse> getFlightByRequest(final AirFlightRequest entity) {
    return airFlightRepository.findByRequest(entity);
  }

  /**
   * Add some flights at application startup for testing
   */
  @PostConstruct
  public void loadFlights() {
    List<AirFlightResponse> users = Arrays.asList(
                    new AirFlightResponse("British Airways", 1005.25, "E", "LHR", "CDG",
                                    LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT).plusDays(10),
                                    LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT).plusDays(11)),
                    new AirFlightResponse("IBERIA", 1025.25, "C", "LHR", "CDG", LocalDateTime.now().plusDays(13),
                                    LocalDateTime.now().plusDays(14)),
                    new AirFlightResponse("Air India", 2255.25, "X", "LON", "PAR", LocalDateTime.now().plusDays(5),
                                    LocalDateTime.now().plusDays(6)));
    airFlightRepository.save(users);
  }

}
