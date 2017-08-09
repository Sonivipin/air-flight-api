package com.mycompany.air.service;

import java.io.Serializable;
import java.util.List;

import com.mycompany.air.model.AirFlightRequest;

public interface CRUDServices<E> {

  E saveFlight(final E entity);

  List<E> getAllAirFlights();

  void deleteFlight(final Serializable id);

  List<E> getFlightByRequest(final AirFlightRequest entity);
}
