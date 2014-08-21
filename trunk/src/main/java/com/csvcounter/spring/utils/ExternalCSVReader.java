package com.csvcounter.spring.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.csvcounter.spring.model.CompanyQuotes;

import au.com.bytecode.opencsv.CSVReader;


public class ExternalCSVReader {

	private String urlStr;

	public ExternalCSVReader(String url) {
		super();
		this.urlStr = url;
	}
	
	public List<CompanyQuotes> getData() throws IOException{
		URL url = new URL(urlStr);
		URLConnection urlConn = url.openConnection();
		InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
		BufferedReader buff = new BufferedReader(inStream);
		CSVReader reader = new CSVReader(buff);
		List<String[]> stringsList = reader.readAll();
		List<CompanyQuotes> quotesList = CompanyQuotesParser.parseCompanyQuotes(stringsList);
		reader.close();
		return quotesList;
	}
	
}
