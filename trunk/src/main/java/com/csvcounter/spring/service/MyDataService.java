package com.csvcounter.spring.service;

import java.util.List;
import java.util.concurrent.Future;

import com.csvcounter.spring.domain.MyData;
import com.csvcounter.spring.model.CompanyQuotes;

public interface MyDataService {
	
	void saveData(List<CompanyQuotes> quotesList);
	
	List<MyData> readData();

	void saveRow(CompanyQuotes companyQuotes);
	
}
