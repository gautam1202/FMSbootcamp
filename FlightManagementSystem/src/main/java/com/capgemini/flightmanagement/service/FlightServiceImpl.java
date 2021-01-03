package com.capgemini.flightmanagement.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.entity.Flight;
import com.capgemini.flightmanagement.exception.FlightDetailsNotFoundException;
import com.capgemini.flightmanagement.exception.NullFlightDetailsException;
import com.capgemini.flightmanagement.repository.FlightRepository;

@Service
public class FlightServiceImpl implements IFlightService{
	
		@Autowired
		FlightRepository flightRepository;

		@Override
		public List<Flight> getAllFlightDetails() 
		{
			return flightRepository.findAll();
		}
		
		@Override
		public Flight viewFlight(BigInteger flightId) 
		{
			Optional<Flight> viewdetails = flightRepository.findById(flightId);
				return viewdetails.get();
			}
			

		@Override
		public Flight addFlightDetails(Flight flight) 
		{
			if (flight == null) {
				throw new NullFlightDetailsException("no data provided");
			}
			flightRepository.save(flight);
			return flight;
		}

		@Override
		public void deleteFlight(BigInteger flightId) 
		{
			if (flightId == null)
				throw new NullFlightDetailsException("No data recieved..");
			Optional<Flight> deletedetails = flightRepository.findById(flightId);
			if (!deletedetails.isPresent()) {
				throw new FlightDetailsNotFoundException("Flight Details not found");
			}
			 flightRepository.deleteById(flightId);
					}

		@Override
		public Flight updateFlight(Flight flight) {
			if (flight == null) {
				throw new NullFlightDetailsException("no data provided");
			}
			Optional<Flight> updatedetails = flightRepository.findById(flight.getFlightId());
			if (!updatedetails.isPresent()) {
				throw new FlightDetailsNotFoundException("Flight Details not found");
			}
			return flightRepository.save(flight);
			
		}
		
		


}
