package com.homework14.part2.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.homework14.part2.exception.ResourceNotFoundException;
import com.homework14.part2.model.Teacher;
import com.homework14.part2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;


    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity <Teacher> getTeacherById(
            @PathVariable(value = "id") Long instructorId) throws ResourceNotFoundException {
        Teacher user = teacherRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found :: " + instructorId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/teachers")
    public Teacher createUser(@Valid @RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity <Teacher> updateUser(
            @PathVariable(value = "id") Long teacherId,
            @Valid @RequestBody Teacher userDetails) throws ResourceNotFoundException {
        Teacher user = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + teacherId));
        user.setEmail(userDetails.getEmail());
        final Teacher updatedUser = teacherRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/teachers/{id}")
    public Map < String, Boolean > deleteUser(
            @PathVariable(value = "id") Long teacherId) throws ResourceNotFoundException {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found :: " + teacherId));

        teacherRepository.delete(teacher);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}