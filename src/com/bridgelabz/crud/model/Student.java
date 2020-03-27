package com.bridgelabz.crud.model;

public class Student {
	String name;
	String usn;
	int age;
	String schoolName;
	int marks;

	public Student() {

	}

	public Student(String name, String usn, int age, String schoolName, int marks) {
		super();
		this.name = name;
		this.usn = usn;
		this.age = age;
		this.schoolName = schoolName;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

}
