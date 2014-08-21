package com.csvcounter.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csvcounter.spring.dao.CounterDAO;
import com.csvcounter.spring.domain.Counter;
import com.csvcounter.spring.service.AppStartupService;

@Service
public class AppStartupServiceImpl implements AppStartupService, ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private CounterDAO counterDAO; 
	
	private final Logger logger = LoggerFactory.getLogger(AppStartupServiceImpl.class);
	
	@Override
	public void prepareDB() {
		logger.info("Preparing database on application startup...");
		if(counterDAO.fetchCounterByName("QN_ID") == null) {
			Counter counter = new Counter();
			counter.setName("QN_ID");
			counter.setValue(0);
			counterDAO.saveOrUpdate(counter);
		}
	}

	@Transactional
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		prepareDB();		
	}

}
