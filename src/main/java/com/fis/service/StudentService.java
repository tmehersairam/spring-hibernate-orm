package com.fis.service;

import java.util.List;

import com.fis.entity.Student;
import com.fis.repository.StudentDao;

public class StudentService {

	StudentDao studentDaoImpl;

	public StudentService(StudentDao studentDaoImpl) {
		this.studentDaoImpl = studentDaoImpl;
	}

	public Student get(int id) {

		Student student = studentDaoImpl.get(id);
		if (student == null)
			throw new RuntimeException("No Student with Id as '" + id + "' ");
		else {
			return student;
		}
	}

	public List<Student> getAll() {
		return studentDaoImpl.getAll();
	}

	public void insert(Student student) {
		studentDaoImpl.insert(student);
		System.out.println("                - inserted");
	}

	public void update(Student student, int id) {
		try {
			Student studentFromDb = get(id);
			studentFromDb.setName(student.getName());
			studentFromDb.setCity(student.getCity());
			studentFromDb.setPhoneNo(student.getPhoneNo());
			studentDaoImpl.update(studentFromDb);
			System.out.println("                - updated");
		} catch (Exception e) {
			System.err.println(e.getMessage() + "Unable to update");
		}

	}

	public void delete(int id) {

		try {
			Student studentFromDb = get(id);
			studentDaoImpl.delete(studentFromDb);
			System.out.println("                - deleted");
		} catch (Exception e) {
			System.err.println(e.getMessage() + "Unable to delete");
		}

	}
}
