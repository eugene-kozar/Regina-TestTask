package com.csvcounter.spring.exception;

public class CSVReadException extends CounterException {

	private static final long serialVersionUID = 7726573452495311112L;

	public CSVReadException() {
		super("Error occured while reading CSV file.");
	}
	
	public CSVReadException(Exception e) {
		super(e);
	}

	public CSVReadException(String message) {
		super(message);
	}
	
}
