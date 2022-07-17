package com.hemanth.codes;

public class Student {

	private int studentId;
	private String studentName;

	public Student() {
		System.out.println("I am a Student from Default Constructor!");
	}

	public Student(int studentId, String studentName) {
		System.out.println("I am a Student from parameterized Constructor!");
		this.studentId = studentId;
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int id) {
		this.studentId = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String name) {
		this.studentName = name;
	}

	public String toString() {
		return "Student-ID: " + this.studentId + " " + "Student-Name: " + this.studentName;
	}

	public void startSchooling() {
		System.out.println("I joined a school to study!");
	}

	// This method can be used as a destroy-method attribute, if the type of class
	// is singleton
	public void finishSchooling() {
		System.out.println("I finished my Schooling!");
	}

}
