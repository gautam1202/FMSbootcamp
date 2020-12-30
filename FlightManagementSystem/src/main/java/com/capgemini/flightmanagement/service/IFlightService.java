package com.capgemini.flightmanagement.service;

import java.math.BigInteger;
import java.util.List;
import com.capgemini.flightmanagement.entity.Flight;

public interface IFlightService {
	public List<Flight> getAllFlightDetails();
	
	public Flight viewFlight(BigInteger flightId);

	public Flight addFlightDetails(Flight flight);

	public void deleteFlight(BigInteger flightId);

	public Flight updateFlight(Flight flight);

}
