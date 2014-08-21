package com.csvcounter.spring.test.util;

import java.util.LinkedList;
import java.util.List;

import com.csvcounter.spring.model.CompanyQuotes;

public class CompanyQuotesBuilder {
	
	public static List<CompanyQuotes> createQuotes() {
		List<CompanyQuotes> quotesListDummy = new LinkedList<CompanyQuotes>();
		quotesListDummy.add(new CompanyQuotes("Name1", 1, 1));
		quotesListDummy.add(new CompanyQuotes("Name2", 2, 2));
		quotesListDummy.add(new CompanyQuotes("Name3", 3, 3));
		return quotesListDummy;
	}
}
