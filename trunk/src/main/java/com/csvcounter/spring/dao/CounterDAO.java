package com.csvcounter.spring.dao;

import com.csvcounter.spring.domain.Counter;

public interface CounterDAO extends GenericDAO<Counter>{

    public Counter fetchCounterByName(String name);
    
}
