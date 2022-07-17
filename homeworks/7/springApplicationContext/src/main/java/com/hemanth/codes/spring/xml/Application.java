package com.hemanth.codes.spring.xml;

import com.hemanth.codes.PhysicsTeacher;
import com.hemanth.codes.Teacher;
import com.hemanth.codes.MathematicsTeacher;

public class Application {
	private Teacher mathematicsTeacher;
	private Teacher physicsTeacher;

	public Application() {

	}

	public Application(PhysicsTeacher physicsTeacher, MathematicsTeacher mathematicsTeacher) {
		this.physicsTeacher = physicsTeacher;
		this.mathematicsTeacher = mathematicsTeacher;
	}

	public void callTeachMethods() {
		physicsTeacher.teach();
		mathematicsTeacher.teach();
	}

	public Teacher getCircle() {
		return physicsTeacher;
	}

	public void setCircle(Teacher physicsTeacher) {
		this.physicsTeacher = physicsTeacher;
	}

	public Teacher getTriangle() {
		return mathematicsTeacher;
	}

	public void setTriangle(Teacher mathematicsTeacher) {
		this.mathematicsTeacher = mathematicsTeacher;
	}
}