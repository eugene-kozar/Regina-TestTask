package com.csvcounter.spring.test;

import static org.junit.Assert.assertEquals;

import java.io.Serializable;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.csvcounter.spring.model.CompanyQuotes;
import com.csvcounter.spring.service.CSVExternalDataService;

public class GetDataFromURLTest  extends AbstractTest<Serializable>{
	@Autowired
	private CSVExternalDataService CsvExternalDataService;
	
	@Test
	public void getCSVDataTest() {
		List<CompanyQuotes> data = CsvExternalDataService.readDataFromURL();
		assertEquals(data.get(0).getName(), "Apple Inc.");
		assertEquals(data.get(1).getName(), "Google Inc.");
		assertEquals(data.get(2).getName(), "Microsoft Corpora");
	}
} 