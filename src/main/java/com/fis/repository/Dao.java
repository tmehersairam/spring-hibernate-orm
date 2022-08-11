package com.fis.repository;

import java.util.List;

public interface Dao<T> {

	int insert(T t);

	int update(T t);

	int delete(T t);

	T get(int id);

	List<T> getAll();

}
