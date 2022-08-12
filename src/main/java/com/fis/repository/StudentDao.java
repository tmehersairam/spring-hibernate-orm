package com.fis.repository;

import java.util.List;

import com.fis.entity.Student;

public interface StudentDao {

	int insert(Student student);

	void update(Student student);

	void delete(Student student);

	Student get(int id);

	List<Student> getAll();

}
