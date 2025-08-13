package com.task2;

public class Student {
	public int rollNo;
	public String name;
	public int age;
	public int marks;
	public String email;
	public String address;
	
	
	

//	public Student(int rollNo, String name, int age, int marks, String email, String address) {
//		super();
//		this.rollNo = rollNo;
//		this.name = name;
//		this.age = age;
//		this.marks = marks;
//		this.email = email;
//		this.address = address;
//	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", age=" + age + ", marks=" + marks + ", email=" + email
				+ ", address=" + address + "]";
	}
	
	
}
