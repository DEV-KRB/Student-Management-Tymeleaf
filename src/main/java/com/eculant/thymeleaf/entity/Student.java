package com.eculant.thymeleaf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rno")
	private int rno;
	
	@Column(name="sname")
	private String sname;
	
	@Column(name="age")
	private int age;
	
	public Student() {
		
	}

	public Student(int rno, String sname, int age) {
		this.rno = rno;
		this.sname = sname;
		this.age = age;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [rno=" + rno + ", sname=" + sname + ", age=" + age + "]";
	}
	
}
