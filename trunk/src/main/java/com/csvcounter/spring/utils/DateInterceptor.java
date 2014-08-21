package com.csvcounter.spring.utils;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.csvcounter.spring.domain.MyData;

public class DateInterceptor extends EmptyInterceptor{
	
	private static final long serialVersionUID = -4601467691771902587L;

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		MyData data = null;
		if(entity instanceof MyData) {
			data = (MyData)entity;
			data.setRecordCreatedDate(new Date());
		}		
		return super.onSave(data, id, state, propertyNames, types);
	}
	
}
