package com.csvcounter.spring.dao;

import com.csvcounter.spring.domain.MyData;

public interface MyDataDAO extends GenericDAO<MyData>{

	public MyData fetchMyDataById(Integer id);
	
}
