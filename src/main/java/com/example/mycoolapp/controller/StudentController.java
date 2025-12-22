package com.example.mycoolapp.controller;

import com.example.mycoolapp.entity.Student;
import com.example.mycoolapp.repository.StudentDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentDAO studentDAO;

    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }


    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return this.studentDAO.findAll();
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return this.studentDAO.findById(studentId);
    }
}
