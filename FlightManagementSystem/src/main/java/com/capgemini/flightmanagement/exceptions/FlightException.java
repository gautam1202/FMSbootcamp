package com.capgemini.flightmanagement.exceptions;

public class FlightException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public FlightException()
	{
		super();
	}
	
	public FlightException(String message)
	{
		super(message);
	}

}
