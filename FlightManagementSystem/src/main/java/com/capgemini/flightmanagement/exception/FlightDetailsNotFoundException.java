
package com.capgemini.flightmanagement.exception;

public class FlightDetailsNotFoundException extends RuntimeException {
	
	public FlightDetailsNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FlightDetailsNotFoundException(String s) {
		super(s);
	}

}