package com.capgemini.flightmanagement.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.dao.FlightDao;
import com.capgemini.flightmanagement.entity.Flight;

@Service
public class FlightServiceImpl implements IFlightService{
	
		@Autowired
		FlightDao flightDao;

		@Override
		public List<Flight> getAllFlightDetails() 
		{
			return flightDao.findAll();
		}
		
		@Override
		public Flight viewFlight(BigInteger flightId) 
		{
			Optional<Flight> viewdetails = flightDao.findById(flightId);
				return viewdetails.get();
			}
			

		@Override
		public Flight addFlightDetails(Flight flight) 
		{
//			Optional<Flight> flightdetails = flightDao.findById(flight);
			 flightDao.save(flight);
			 return flight;
		}

		@Override
		public void deleteFlight(BigInteger flightId) 
		{
			Optional<Flight> deletedetails = flightDao.findById(flightId);
			 flightDao.deleteById(flightId);
					}

		@Override
		public Flight updateFlight(Flight flight) {
			Optional<Flight> updatedetails = flightDao.findById(flight.getFlightId());
			return flightDao.save(flight);
			
		}
		
		


}
