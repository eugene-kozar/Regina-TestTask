package com.csvcounter.spring.utils;

import com.csvcounter.spring.model.CompanyQuotes;

public class StringUtils {
	public static String concatData(CompanyQuotes quotes) {
		String quoteRow = quotes.getName() + "|" + quotes.getFirstQuote() + "|" + quotes.getSecondQuote();
		return quoteRow;
	}
}
