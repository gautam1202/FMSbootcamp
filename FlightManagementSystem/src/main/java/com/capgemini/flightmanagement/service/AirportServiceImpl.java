package com.capgemini.flightmanagement.service;

import java.math.BigInteger;

import java.util.Optional;

import com.capgemini.flightmanagement.entity.Airport;
import com.capgemini.flightmanagement.exception.RecordAlreadyPresentException;
import com.capgemini.flightmanagement.exception.RecordNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagement.repository.AirportRepository;

@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	AirportRepository airportRepository;

	/*
	 * view all Airport
	 */
	@Override
	public Iterable<Airport> viewAllAirport() {
		return airportRepository.findAll();
	}

	/*
	 * view airport by airportCode
	 */
	@Override
	public Airport viewAirport(BigInteger airportCode) {
		Optional<Airport> findById = airportRepository.findById(airportCode);
		if (findById.isPresent()) {
			return findById.get();
		}
			
			//return new ResponseEntity<Airport>(airport, HttpStatus.OK)}
		else
			throw new RecordNotFoundException("Airport with airport code: " + airportCode + "not exists");
	    }
		/*catch(RecordNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
        }*/

	/*
	 * add a airport
	 */
	@Override
	public ResponseEntity<Airport> addAirport(Airport airport) {
		Optional<Airport> findById = airportRepository.findById(airport.getAirportCode());
		try {
		if (!findById.isPresent()) {
			airportRepository.save(airport);
			return new ResponseEntity<Airport>(airport,HttpStatus.OK);
		} 
		else
			throw new RecordAlreadyPresentException(
					"Airport with code : " + airport.getAirportCode() + " already present");
	     }
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<Airport>(airport,HttpStatus.NOT_FOUND);
		}
	}
	/*
	 * modify an Airport
	 */
	@Override
	public Airport modifyAirport(Airport airport) {
		Optional<Airport> findById = airportRepository.findById(airport.getAirportCode());
		if (findById.isPresent()) {
			airportRepository.save(airport);
		} 
		else
			throw new RecordNotFoundException("Airport with code: " + airport.getAirportCode() + " not exists");
		return airport;
	}

	/*
	 * remove an airport
	 */
	@Override
	public String removeAirport(BigInteger airportCode) {
		Optional<Airport> findById = airportRepository.findById(airportCode);
		if (findById.isPresent()) {
			airportRepository.deleteById(airportCode);
			return "Airport removed";
		} else
			throw new RecordNotFoundException("Airport with code: " + airportCode + " not exists");

	}
}
