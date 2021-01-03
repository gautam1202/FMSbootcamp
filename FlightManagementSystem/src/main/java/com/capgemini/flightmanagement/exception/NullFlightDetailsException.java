
package com.capgemini.flightmanagement.exception;

public class NullFlightDetailsException extends RuntimeException {

	public NullFlightDetailsException(String message, Throwable cause) {
		super(message, cause);
	}

	public NullFlightDetailsException(String message) {
		super(message);
	}
	
}