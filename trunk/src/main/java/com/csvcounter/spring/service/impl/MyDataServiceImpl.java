package com.csvcounter.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csvcounter.spring.dao.MyDataDAO;
import com.csvcounter.spring.domain.MyData;
import com.csvcounter.spring.exception.DBReadException;
import com.csvcounter.spring.exception.DBSaveException;
import com.csvcounter.spring.model.CompanyQuotes;
import com.csvcounter.spring.service.CounterService;
import com.csvcounter.spring.service.MyDataService;
import com.csvcounter.spring.utils.StringUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MyDataServiceImpl implements MyDataService {

	@Autowired
	private MyDataDAO myDataDAO;
	@Autowired
	private CounterService counterService;
	
	@Transactional
	@Override
	@HystrixCommand()
	public void saveData(List<CompanyQuotes> quotesList) {
		try {
			for(CompanyQuotes quotes : quotesList) {
				saveRow(quotes);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBSaveException(e);
		}
		
	}
	
	@Transactional
	@HystrixCommand
	public void saveRow(CompanyQuotes row) {
		String concatedString = StringUtils.concatData(row);
		counterService.increment();
		int id = counterService.getValue();
		MyData myData = new MyData();
		myData.setId(id);
		myData.setData(concatedString);
		myDataDAO.saveOrUpdate(myData);
	}

	@Transactional
	@Override
	@HystrixCommand
	public List<MyData> readData() {
		try {
			return myDataDAO.fetchAll(MyData.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBReadException();
		}
	}
	
}
