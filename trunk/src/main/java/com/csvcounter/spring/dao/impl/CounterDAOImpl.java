package com.csvcounter.spring.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.csvcounter.spring.dao.CounterDAO;
import com.csvcounter.spring.domain.Counter;

@Repository
public class CounterDAOImpl extends GenericDAOImpl<Counter> implements CounterDAO {
	
	@Override
	public Counter fetchCounterByName(String name) {
		Query query = getSession().createQuery("from Counter where name like :name");
		query.setString("name", name);
        return (Counter) query.uniqueResult();
	}

}
