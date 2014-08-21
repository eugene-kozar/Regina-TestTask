package com.csvcounter.spring.utils;

import java.util.LinkedList;
import java.util.List;

import com.csvcounter.spring.model.CompanyQuotes;

public class CompanyQuotesParser {
	
	public static List<CompanyQuotes> parseCompanyQuotes(List<String[]> stringsData){
		List<CompanyQuotes> quotesList = new LinkedList<CompanyQuotes>();
		for (String[] strings : stringsData) {
			CompanyQuotes companyQuotes = new CompanyQuotes();
			companyQuotes.setName(strings[0]);
			companyQuotes.setFirstQuote(parseDouble(strings[1]));
			companyQuotes.setSecondQuote(parseDouble(strings[2]));
			quotesList.add(companyQuotes);
		}
		return quotesList;
	}
	
	public static double parseDouble(String value){
		return Double.parseDouble(value);
	}
}
