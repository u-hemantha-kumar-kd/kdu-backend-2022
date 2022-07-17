package com.hemanth.codes.spring.java;

import com.hemanth.codes.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Application {
	@Autowired
	@Qualifier("myPhysicsTeacher")
	private Teacher physicsTeacher;

	@Autowired
	@Qualifier("myMathematicsTeacher")
	private Teacher mathematicsTeacher;

	public void callTeachingMethods() {
		mathematicsTeacher.teach();
		physicsTeacher.teach();
	}
}