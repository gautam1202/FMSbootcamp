package com.capgemini.flightmanagement.exception;

public class RecordNotFoundException extends RuntimeException {
	public RecordNotFoundException(String s, Throwable cause) 
	{
		super(s, cause);
	}
	public RecordNotFoundException(String s) 
	{
		super(s);
	}
}