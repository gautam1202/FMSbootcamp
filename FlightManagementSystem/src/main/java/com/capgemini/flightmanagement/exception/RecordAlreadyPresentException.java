package com.capgemini.flightmanagement.exception;

public class RecordAlreadyPresentException extends RuntimeException {
	public RecordAlreadyPresentException(String s, Throwable cause) 
	{
		super(s, cause);
	}
	public RecordAlreadyPresentException(String s) 
	{
		super(s);
	}
}