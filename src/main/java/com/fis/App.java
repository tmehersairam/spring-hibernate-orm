package com.fis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fis.entity.Student;
import com.fis.repository.StudentDao;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/fis/config.xml");

		StudentDao daoImpl = (StudentDao) context.getBean("studentDao");
		daoImpl.insert(new Student("zen", 23423, "somewhere"));

		Student studentFromDb = daoImpl.get(3);
		studentFromDb.setCity("mars");
		daoImpl.update(studentFromDb);
		System.out.println(studentFromDb);

		daoImpl.delete(studentFromDb);
		System.out.println(daoImpl.getAll());
	}
}
