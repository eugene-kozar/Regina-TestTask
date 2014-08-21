package com.csvcounter.spring.model;

public class CompanyQuotes {
	
	private String name;
	private double firstQuote;
	private double secondQuote;
	
	public CompanyQuotes() {
		super();
	}
	
	public CompanyQuotes(String name, double firstQuote, double secondQuote) {
		super();
		this.name = name;
		this.firstQuote = firstQuote;
		this.secondQuote = secondQuote;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFirstQuote() {
		return firstQuote;
	}
	public void setFirstQuote(double firstQuote) {
		this.firstQuote = firstQuote;
	}
	public double getSecondQuote() {
		return secondQuote;
	}
	public void setSecondQuote(double secondQuote) {
		this.secondQuote = secondQuote;
	}
	
	@Override
	public String toString() {
		return "CompanyQuotes [name=" + name + ", firstQuote=" + firstQuote
				+ ", secondQuote=" + secondQuote + "]";
	}
	
}
