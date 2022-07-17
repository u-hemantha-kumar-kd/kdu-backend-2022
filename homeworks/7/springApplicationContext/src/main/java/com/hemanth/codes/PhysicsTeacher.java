package com.hemanth.codes;

public class PhysicsTeacher implements Teacher{
	private int id; 
	private String subject;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public void teach() {
		System.out.println("I teach Physics!");
	} 
}
