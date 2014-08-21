package com.csvcounter.spring.exception;

public class DBReadException extends CounterException {

	private static final long serialVersionUID = 3210407821305291313L;

	public DBReadException() {
		super("Error occured while reading data from database.");
	}
	
	public DBReadException(Exception e) {
		super(e);
	}

	public DBReadException(String message) {
		super(message);
	}
	
}
