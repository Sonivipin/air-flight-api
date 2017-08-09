package com.mycompany.air.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.air.model.AirFlightRequest;
import com.mycompany.air.model.AirFlightResponse;

@Repository
public interface AirFlightRepository extends JpaRepository<AirFlightResponse, Long> {

@Query("select af from AirFlightResponse af where af.departureAirportCode = :#{#airFlightRequest.origin} and af.destinationAirportCode=:#{#airFlightRequest.destination} and af.departureDate like :#{#airFlightRequest.departureDateTime}")
//  @Query("select af from AirFlightResponse af where af.departureAirportCode = :#{#airFlightRequest.origin} and af.destinationAirportCode = :#{#airFlightRequest.destination}")
  List<AirFlightResponse> findByRequest(@Param("airFlightRequest") final AirFlightRequest airFlightRequest);

}
