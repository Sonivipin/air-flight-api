package com.mycompany.air.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SuppressWarnings("serial")
@Entity
@Table(name = "airFlightResponse")
public class AirFlightResponse implements Serializable {

  @Id
  @Column(name = "airline", nullable = false, length = 25)
  private String airline;// Name of the airline

  @Column(name = "price", nullable = false, length = 10)
  private Double price; // Total price

  @Column(name = "cabinclass", nullable = false, length = 1)
  private String cabinclass;// E for Economy and B for Business

  @Column(name = "departureAirportCode", nullable = false, length = 3)
  private String departureAirportCode;// Eg: LHR

  @Column(name = "destinationAirportCode", nullable = false, length = 3)
  private String destinationAirportCode;// Eg: LHR

  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @Column(name = "departureDate", nullable = false)
  private LocalDateTime departureDate;// ISO_LOCAL_DATE_TIME format

  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @Column(name = "arrivalDate", nullable = false)
  private LocalDateTime arrivalDate;// ISO_LOCAL_DATE_TIME format

  /**
   * Default constructor for entity bean creation.
   */
  public AirFlightResponse() {
  }

  /**
   * 
   * @param airline
   * @param price
   * @param cabinclass
   * @param departureAirportCode
   * @param destinationAirportCode
   * @param departureDate
   * @param arrivalDate
   */
  public AirFlightResponse(final String airline, final Double price, final String cabinclass,
                  final String departureAirportCode, final String destinationAirportCode,
                  final LocalDateTime departureDate, final LocalDateTime arrivalDate) {
    super();
    this.airline = airline;
    this.price = price;
    this.cabinclass = cabinclass;
    this.departureAirportCode = departureAirportCode;
    this.destinationAirportCode = destinationAirportCode;
    this.departureDate = departureDate;
    this.arrivalDate = arrivalDate;
  }

  /**
   * @return the airline
   */
  public String getAirline() {
    return airline;
  }

  /**
   * @param airline
   *          the airline to set
   */
  public void setAirline(final String airline) {
    this.airline = airline;
  }

  /**
   * @return the price
   */
  public Double getPrice() {
    return price;
  }

  /**
   * @param price
   *          the price to set
   */
  public void setPrice(final Double price) {
    this.price = price;
  }

  /**
   * @return the cabinclass
   */
  public String getCabinclass() {
    return cabinclass;
  }

  /**
   * @param cabinclass
   *          the cabinclass to set
   */
  public void setCabinclass(final String cabinclass) {
    this.cabinclass = cabinclass;
  }

  /**
   * @return the departureAirportCode
   */
  public String getDepartureAirportCode() {
    return departureAirportCode;
  }

  /**
   * @param departureAirportCode
   *          the departureAirportCode to set
   */
  public void setDepartureAirportCode(final String departureAirportCode) {
    this.departureAirportCode = departureAirportCode;
  }

  /**
   * @return the destinationAirportCode
   */
  public String getDestinationAirportCode() {
    return destinationAirportCode;
  }

  /**
   * @param destinationAirportCode
   *          the destinationAirportCode to set
   */
  public void setDestinationAirportCode(final String destinationAirportCode) {
    this.destinationAirportCode = destinationAirportCode;
  }

  /**
   * @return the departureDate
   */
  public LocalDateTime getDepartureDate() {
    return departureDate;
  }

  /**
   * @param departureDate
   *          the departureDate to set
   */
  public void setDepartureDate(final LocalDateTime departureDate) {
    this.departureDate = departureDate;
  }

  /**
   * @return the arrivalDate
   */
  public LocalDateTime getArrivalDate() {
    return arrivalDate;
  }

  /**
   * @param arrivalDate
   *          the arrivalDate to set
   */
  public void setArrivalDate(final LocalDateTime arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

}
