package com.csvcounter.spring.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.csvcounter.spring.dao.MyDataDAO;
import com.csvcounter.spring.domain.MyData;

@Repository
public class MyDataDAOImpl extends GenericDAOImpl<MyData> implements MyDataDAO {

	@Override
	public MyData fetchMyDataById(Integer id) {
		Query query = getSession().createQuery("from MyData where id = :id");
		query.setInteger("id", id);
        return (MyData) query.uniqueResult();
	}

}
