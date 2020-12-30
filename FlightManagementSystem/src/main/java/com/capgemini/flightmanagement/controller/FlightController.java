package com.capgemini.flightmanagement.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagement.entity.Flight;
import com.capgemini.flightmanagement.exceptions.FlightException;
import com.capgemini.flightmanagement.service.IFlightService;

@CrossOrigin(origins="http://localhost:1080")
@RestController
@Validated
public class FlightController {
	
	@Autowired
	IFlightService flightservice;
	
	@PostMapping("/addFlight")
	public ResponseEntity<Flight> addFlight(@Valid @RequestBody Flight flight)
	{
		Flight flightdetails = flightservice.addFlightDetails(flight);
		return ResponseEntity.ok().body(flightdetails);
		
	}
	
	@GetMapping("/getAllFlight")
	public ResponseEntity<List<Flight>> getAllFlightDetails()
	{
		List<Flight> list = flightservice.getAllFlightDetails();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/viewFlight/{flightId}")
	public ResponseEntity<Object> viewFlight(@PathVariable("flightId") BigInteger flightId)
	{
		flightservice.viewFlight(flightId);
		return new ResponseEntity<>("Flights",HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteFlightDetails/{flightId}")
	public void deleteFlight(@PathVariable BigInteger flightId) {
		flightservice.deleteFlight(flightId);
	}
	
//	
//	@DeleteMapping("/deleteFlight/{flightId}")
//	public ResponseEntity<Object> deleteFlight(@PathVariable("flightId") BigInteger flightId)
//	{
//		flightservice.deleteFlight(flightId);
//		return new ResponseEntity<>("Flight deleted Successfully", HttpStatus.OK);
//	}
	
	
	@PostMapping("/updateFlightDetails")
	public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight){
		Flight flightdetails = flightservice.updateFlight(flight);
		return ResponseEntity.ok().body(flightdetails);
	}
	
//	@PutMapping ("/updateFlight/{flightId}")
//	public ResponseEntity<Object> updateFlight(@PathVariable("flightId") BigInteger flightId,@RequestBody Flight flight)
//	{
////		if(flight.getSeatCapacity()>200)throw new FlightException("Seating Capacity should not exceeds 200");
//	    flightservice.updateFlight(flight);
//	    return new ResponseEntity<>("Flight Updated SuccessFully", HttpStatus.OK);
//	}

}
