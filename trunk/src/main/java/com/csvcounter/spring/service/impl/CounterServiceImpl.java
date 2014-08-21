package com.csvcounter.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csvcounter.spring.dao.CounterDAO;
import com.csvcounter.spring.domain.Counter;
import com.csvcounter.spring.service.CounterService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CounterServiceImpl implements CounterService{
	private static final String COUNTER_NAME = "QN_ID";
	
	@Autowired
	private CounterDAO counterDAO;
	
	@Override
	@Transactional
	@HystrixCommand
	public void increment() {
		Counter counter = counterDAO.fetchCounterByName(COUNTER_NAME);
		int value = counter.getValue() + 1;
		counter.setValue(value);
		counterDAO.saveOrUpdate(counter);
	}

	@Override
	@Transactional
	@HystrixCommand
	public int getValue() {
		return counterDAO.fetchCounterByName(COUNTER_NAME).getValue();
	}

	@Override
	@Transactional
	@HystrixCommand
	public void setValue(Integer id) {
		Counter counter = counterDAO.fetchCounterByName(COUNTER_NAME);
		counter.setValue(id);
		counterDAO.saveOrUpdate(counter);
	}

}
