package com.csvcounter.spring.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csvcounter.spring.domain.MyData;
import com.csvcounter.spring.exception.CounterException;
import com.csvcounter.spring.model.CompanyQuotes;
import com.csvcounter.spring.service.CSVExternalDataService;
import com.csvcounter.spring.service.MyDataService;

@Controller
public class GetDataController {

	@Autowired
	private CSVExternalDataService CSVExternalDataService;
	@Autowired
	private MyDataService myDataService;
	
	private final Logger logger = LoggerFactory.getLogger(GetDataController.class);
	
    @RequestMapping(value = "/getdata", method = RequestMethod.POST)
	public String getData(Locale locale, Model model) {
    	try {
        	logger.info("Welcome to Get Data Controller!");
        	List<CompanyQuotes> quotesList = CSVExternalDataService.readDataFromURL();
			myDataService.saveData(quotesList);
        	List<MyData> dataList = myDataService.readData();
        	model.addAttribute("dataList", dataList);
		} catch (CounterException e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
		}
		return "getdata";
	}
	
}
