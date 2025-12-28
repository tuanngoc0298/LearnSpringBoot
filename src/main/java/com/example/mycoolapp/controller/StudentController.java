package com.example.mycoolapp.controller;

import com.example.mycoolapp.entity.Student;
import com.example.mycoolapp.exception.student.StudentNotFoundException;
import com.example.mycoolapp.exception.student.response.StudentErrorResponse;
import com.example.mycoolapp.repository.student.StudentDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Student student  = this.studentDAO.findById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student with id: " + studentId + " not found");
        }
        return student;
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        // Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
