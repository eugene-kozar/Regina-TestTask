package com.csvcounter.spring.dao;

import java.util.List;

import org.hibernate.Session;

public interface GenericDAO<T> {
	
	void saveOrUpdate(T object);

	List<T> fetchAll(Class<T> objectClass);

	void delete(T object);
	
	Session getSession();
	
}
