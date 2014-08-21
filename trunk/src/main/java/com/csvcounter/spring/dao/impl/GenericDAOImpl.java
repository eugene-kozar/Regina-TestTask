package com.csvcounter.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csvcounter.spring.dao.GenericDAO;
import com.csvcounter.spring.utils.DateInterceptor;

@Repository
public class GenericDAOImpl<T> implements GenericDAO<T>{

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(T object) {
		getSession().saveOrUpdate(object);
	}

	@SuppressWarnings("unchecked")
	public List<T> fetchAll(Class<T> objectClass) {
		return getSession().createQuery("from " + objectClass.getName()).list();
	}

	@Override
	public void delete(T object) {
		getSession().delete(object);		
	}

	@Override
	public Session getSession() {
		sessionFactory.openSession(new DateInterceptor());
		return sessionFactory.getCurrentSession();
	}

}
