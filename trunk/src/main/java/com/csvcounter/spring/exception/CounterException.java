package com.csvcounter.spring.exception;

public class CounterException extends RuntimeException {

	private static final long serialVersionUID = 2918444903367212898L;

	public CounterException() {
		super("General application exception has occured.");
	}
	
	public CounterException(Exception e) {
		super(e);
	}

	public CounterException(String message) {
		super(message);
	}
	
}
