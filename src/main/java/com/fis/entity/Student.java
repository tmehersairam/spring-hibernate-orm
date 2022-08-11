package com.fis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "student_details")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private long phoneNo;

	@Column(nullable = false)
	private String city;

	public Student() {
	}

	public Student(int id, String name, long phoneNo, String city) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.city = city;
	}

	public Student(String name, long phoneNo, String city) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phoneNo=" + phoneNo + ", city=" + city + "]";
	}

}
