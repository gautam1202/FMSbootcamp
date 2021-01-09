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
		
		
		/**********************************************************************************
		* Method        addFlight
		* Description   To add flight with details 
		* returns       This method return string to tell if new flight object is created or not. 
		* Created on    2-January-2021
		* @throws NullFlightDetailsException if no data is provided
		* Created on 2-January-2021
		* Created By Gautam Anand
		**********************************************************************************/
			

		@Override
		public Flight addFlightDetails(Flight flight) 
		{
			if (flight == null) 
			{
				throw new NullFlightDetailsException("no data provided");
			}
			flightRepository.save(flight);
			return flight;
		}
		
		
		
		
		
		/*********************************************************************************************************************
		 * Method: updateFlight
		 * Description: handler mapped with put function to edit the flight details with flightId
		 * @param flightId
		 * @return This method return the message if the flight details updated or not
		 * @throws NullFlightDetailsException if no data is provided 
		 * @throws FlightDetailsNotFoundException if Flight Details are not found
		 * Created on 2-January-2021
		 * Created By Gautam Anand
		 ***********************************************************************************************************************/
	
		
		

		@Override
		public Flight updateFlight(Flight flight) 
		{
			if (flight == null) 
			{
				throw new NullFlightDetailsException("no data provided");
			}
			Optional<Flight> flightdetails = flightRepository.findById(flight.getFlightId());
			if (!flightdetails.isPresent()) 
			{
				throw new FlightDetailsNotFoundException("Flight Details not found");
			}
			return flightRepository.save(flight);
			
		}
		
		

		/*********************************************************************************************************************
		 * Method: deleteFlight
		 * Description: handler mapped with delete function to delete the flight object with flightId
		 * @param flightId
		 * @throws NullFlightDetailsException if no data is recieved 
		 * @throws FlightDetailsNotFoundException if Flight Details are not found
		 * Created on 2-January-2021
		 * Created By Gautam Anand 
		 ***********************************************************************************************************************/
		

		@Override
		public void deleteFlight(BigInteger flightId) 
		{
			if (flightId == null)
				throw new NullFlightDetailsException("No data recieved..");
			Optional<Flight> flightdetails = flightRepository.findById(flightId);
			if (!flightdetails.isPresent()) 
			{
				throw new FlightDetailsNotFoundException("Flight Details not found");
			}
			 flightRepository.deleteById(flightId);
		}
		
		/*********************************************************************************************************************
		 * Method: viewAllFlight
		 * Description: handler mapped with get function to fetch the flight list
		 * @return flightList: list containing the objects of class Flight from the database
		 * Created on 2-January-2021
		 * Created By Gautam Anand 
		 ***********************************************************************************************************************/
		
		@Override
		public List<Flight> getAllFlightDetails() 
		{
			return flightRepository.findAll();
		}
		
		
		/*********************************************************************************************************************
		 * Method: findById
		 * Description: handler mapped with get function to fetch the flight details with flightId
		 * @param flightId
		 * @return flight: details of the flight mapped with given flightId
		 * Created on 2-January-2021
		 * Created By Gautam Anand 
		 ***********************************************************************************************************************/
		
		@Override
		public Flight viewFlight(BigInteger flightId) 
		{
			Optional<Flight> viewdetails = flightRepository.findById(flightId);
				return viewdetails.get();
		}
				


}
