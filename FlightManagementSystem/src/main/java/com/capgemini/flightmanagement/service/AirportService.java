package com.capgemini.flightmanagement.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.capgemini.flightmanagement.entity.Airport;

public interface AirportService {
	public Iterable<Airport> viewAllAirport();

	public Airport viewAirport(BigInteger airportCode);

	public ResponseEntity<Airport> addAirport(Airport airport);

	public Airport modifyAirport(Airport airport);

	public String removeAirport(BigInteger airportCode);
}
