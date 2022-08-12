package com.fis;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fis.entity.Student;
import com.fis.service.StudentService;

/**
 * Hello world!
 *
 */
public class App {

	static Scanner sc;

	static StudentService studentService;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/fis/config.xml");

		studentService = context.getBean("studentService", StudentService.class);

		sc = new Scanner(System.in);

		start();

	}

	public static void start() {
		while (true) {
			displayMenu();
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				studentService.insert(createStudent());
				break;

			case 2:
				updateStudent();
				break;

			case 3:
				deleteStudent();
				break;

			case 4:
				displayOne();
				break;

			case 5:
				displayAll();
				break;
			case 0: {
				System.out.println("Bye...");
				System.exit(0);
			}
				break;
			default:
				System.out.println("Invalid choice");

			}
		}
	}

	private static void displayOne() {
		System.out.println("Enter the student Id");
		int id = Integer.parseInt(sc.nextLine());
		try {
			System.out.println(studentService.get(id));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private static void deleteStudent() {
		System.out.println("Enter the student Id");
		int id = Integer.parseInt(sc.nextLine());

		studentService.delete(id);

	}

	private static void updateStudent() {
		System.out.println("Enter student Id to update");
		int id = Integer.parseInt(sc.nextLine());
		try {
			studentService.get(id);
			Student newStudent = createStudent();
			studentService.update(newStudent, id);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private static Student createStudent() {
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter phone number");
		long phoneNo = Long.parseLong(sc.nextLine());
		System.out.println("Enter city");
		String city = sc.nextLine();
		return new Student(name, phoneNo, city);
	}

	public static void displayAll() {

		System.out.println("----------- Students --------------");
		studentService.getAll().forEach(student -> {
			System.out.println(student);
		});
	}

	public static void displayMenu() {
		System.out.println("1 To insert");
		System.out.println("2 To update");
		System.out.println("3 To delete");
		System.out.println("4 To view one");
		System.out.println("5 To view all");
		System.out.println("0 To exit");
	}
}
