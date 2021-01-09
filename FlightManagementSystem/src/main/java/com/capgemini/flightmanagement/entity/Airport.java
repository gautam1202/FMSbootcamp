package com.capgemini.flightmanagement.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Airport")
public class Airport
/**
 * Class Airport
 */
{
	@Id
	@NotNull
	@Column(name = "airport_code")
	private BigInteger airportCode;
	
	@NotNull(message="location cannot be null")
	@Column(name = "airport_location")
	private String airportLocation;
	
	@NotNull(message="airportName cannot be null")
	@Column(name = "airport_name")
	private String airportName;

	public Airport(String airportName, String airportLocation, BigInteger airportCode)
	/**
	 * parameterized Constructor
	 */
	{
		this.airportName = airportName;
		this.airportLocation = airportLocation;
		this.airportCode = airportCode;
	}

	public Airport()
	/**
	 * Unparameterized Constructor
	 */
	{
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	public BigInteger getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(BigInteger airportCode) {
		this.airportCode = airportCode;
	}

	@Override
	public String toString() {
		return "Airport{" + "airportName='" + airportName + '\'' + ", airportLocation='" + airportLocation + '\''
				+ ", airportCode='" + airportCode + '\'' + '}';
	}
}