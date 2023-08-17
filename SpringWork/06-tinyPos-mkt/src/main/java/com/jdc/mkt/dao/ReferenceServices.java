package com.jdc.mkt.dao;

import java.util.List;

public interface ReferenceServices<T> {

	T findById(int id);
	List<T> findByNameLike(String name);
	
}
