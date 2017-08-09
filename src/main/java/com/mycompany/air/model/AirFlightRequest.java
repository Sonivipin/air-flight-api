package com.mycompany.air.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SuppressWarnings("serial")
public class AirFlightRequest implements Serializable {

  private String origin; // 3 letter IATA code(eg. LHR, AMS)

  private String destination; // 3 letter IATA code(eg. LHR, AMS)

  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDate departureDate; // ISO_LOCAL_DATE format

  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDate returnDate; // ISO_LOCAL_DATE format

  private Integer passengerCount; // Number of passengers

  public AirFlightRequest() {
  }

  /**
   * Constructor used to initialize the field values.
   * 
   * @param origin
   * @param destination
   * @param departureDate
   * @param returnDate
   * @param passengerCount
   */
  public AirFlightRequest(final String origin, final String destination, final LocalDate departureDate,
                  final LocalDate returnDate, final Integer passengerCount) {
    super();
    this.origin = origin;
    this.destination = destination;
    this.departureDate = departureDate;
    this.returnDate = returnDate;
    this.passengerCount = passengerCount;
  }

  /**
   * @return the origin
   */
  public String getOrigin() {
    return origin;
  }

  /**
   * @param origin
   *          the origin to set
   */
  public void setOrigin(final String origin) {
    this.origin = origin;
  }

  /**
   * @return the destination
   */
  public String getDestination() {
    return destination;
  }

  /**
   * @param destination
   *          the destination to set
   */
  public void setDestination(final String destination) {
    this.destination = destination;
  }

  /**
   * @return the departureDate
   */
  public LocalDate getDepartureDate() {
    return departureDate;
  }

  /**
   * @param departureDate
   *          the departureDate to set
   */
  public void setDepartureDate(final LocalDate departureDate) {
    this.departureDate = departureDate;
  }

  /**
   * @return the returnDate
   */
  public LocalDate getReturnDate() {
    return returnDate;
  }

  /**
   * @param returnDate
   *          the returnDate to set
   */
  public void setReturnDate(final LocalDate returnDate) {
    this.returnDate = returnDate;
  }

  /**
   * @return the passengerCount
   */
  public Integer getPassengerCount() {
    return passengerCount;
  }

  /**
   * @param passengerCount
   *          the passengerCount to set
   */
  public void setPassengerCount(final Integer passengerCount) {
    this.passengerCount = passengerCount;
  }

  public LocalDateTime getDepartureDateTime() {
    return LocalDateTime.of(getDepartureDate(), LocalTime.MIDNIGHT);
  }

}
