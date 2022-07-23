package com.homework14.part2.service;

import com.homework14.part2.model.Teacher;
import com.homework14.part2.model.TeacherDetails;
import com.homework14.part2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImplementation {
    @Autowired
    private TeacherRepository teacherRepository;

    public void save(){
        Teacher teacher = new Teacher("Navin", "Reddy", "navinreddy@gmail.com");
        TeacherDetails teacherDetails = new TeacherDetails("Telusko", "Youtuber");
        teacher.setTeacherDetails(teacherDetails);
        teacherRepository.save(teacher);
    }
    public boolean findAll(){
        System.out.println(teacherRepository.findAll());
        return false;
    }
}
