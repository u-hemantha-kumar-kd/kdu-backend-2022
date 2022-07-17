package com.hemanth.codes.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hemanth.codes.Teacher;

public class AppicationWithAnnotation {
	@Autowired
	private Teacher mathematicsTeacher;

	@Autowired
	@Qualifier("physics")
	private Teacher physicsTeacher;

	public Teacher getMathematicsTeacher() {
		return mathematicsTeacher;
	}

	public void setMathematicsTeacher(Teacher mathematicsTeacher) {
		this.mathematicsTeacher = mathematicsTeacher;
	}

	public Teacher getPhysicsTeacher() {
		return physicsTeacher;
	}

	public void setPhysicsTeacher(Teacher physicsTeacher) {
		this.physicsTeacher = physicsTeacher;
	}

	public void callTeachingMethods() {
		physicsTeacher.teach();
		mathematicsTeacher.teach();
	}

}
