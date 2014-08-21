package com.csvcounter.spring.service;

import java.util.List;
import java.util.concurrent.Future;

import com.csvcounter.spring.model.CompanyQuotes;

public interface CSVExternalDataService {

	List<CompanyQuotes> readDataFromURL();
	
}
