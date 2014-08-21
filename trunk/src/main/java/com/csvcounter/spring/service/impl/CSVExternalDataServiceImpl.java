package com.csvcounter.spring.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.csvcounter.spring.exception.CSVReadException;
import com.csvcounter.spring.exception.CounterException;
import com.csvcounter.spring.model.CompanyQuotes;
import com.csvcounter.spring.service.CSVExternalDataService;
import com.csvcounter.spring.utils.ExternalCSVReader;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class CSVExternalDataServiceImpl implements CSVExternalDataService {

	private static final String PROPERTIES_FILE = "/app.properties";
	private static final String ENCODING = "UTF-8";
	private static final String APP_URL = "app.url";
	
	private Properties properties;
	private ExternalCSVReader csvReader;
	
	public CSVExternalDataServiceImpl() {
		properties = new Properties();
		try {
			properties.load(readPropertiesReader());
			csvReader = new ExternalCSVReader(properties.getProperty(APP_URL));
		} catch (IOException e) {
			e.printStackTrace();
			throw new CounterException(e);
		}
	}

	@Override
	@HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreakerRequestVolumeThreshold", value = "1"),
            @HystrixProperty(name = "circuitBreakerSleepWindowInMilliseconds", value = "10000")
        })
	public List<CompanyQuotes> readDataFromURL() {
		try {
			return csvReader.getData();
		} catch (IOException e) {
			e.printStackTrace();
			throw new CSVReadException(e);
		}
	}
	
	private Reader readPropertiesReader() {
		try {
			return new InputStreamReader(getClass().getResourceAsStream(
					PROPERTIES_FILE), ENCODING);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new CounterException(e);
		}
	}

}
