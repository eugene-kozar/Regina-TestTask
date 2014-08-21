package com.csvcounter.spring.exception;

public class DBSaveException extends CounterException {

	private static final long serialVersionUID = -3125832380545267039L;

	public DBSaveException() {
		super("Error occured while saving data to database.");
	}
	
	public DBSaveException(Exception e) {
		super(e);
	}

	public DBSaveException(String message) {
		super(message);
	}
	
}
