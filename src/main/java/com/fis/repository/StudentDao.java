package com.fis.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.fis.entity.Student;

@Transactional
public class StudentDao {

	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Student get(int id) {
		return hibernateTemplate.get(Student.class, id);
	}

	public int insert(Student student) {

		return (int) hibernateTemplate.save(student);
	}

	public void update(Student student) {

		hibernateTemplate.update(student);
	}

	public void delete(Student student) {
		hibernateTemplate.delete(student);
	}

	public List<Student> getAll() {
		return hibernateTemplate.loadAll(Student.class);
	}
}
