package com.jdc.mkt.dao;

public interface UpdateService<T> {

	int insert(T t);
	int update(T t);
	int delete(int id);
	
}
