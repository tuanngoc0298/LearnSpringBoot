package com.example.mycoolapp;

import com.example.mycoolapp.entity.Student;
import com.example.mycoolapp.repository.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");;

		// Create the student object
		Student student = new Student("Ngoc Tuan", "Phan", "test@gmail.com");

		// Save the student object
		System.out.println("Saving student ....");
		studentDAO.save(student);

		// Display id of the saved student
		System.out.println("Saved student " + student.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object...");

		// Creating student object
		Student student = new Student("Ngoc Tuan", "Phan", "test2@gmail.com");

		// Save the student object
		System.out.println("Saving student ....");
		studentDAO.save(student);

		// Display id of the saved student
		System.out.println("Saved student, Generated id: " + student.getId());

		Student myStudent = studentDAO.findById(student.getId());

		System.out.println("Found student " + myStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Phan1");

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 2;
		System.out.println("Updating student with id " + studentId);

		Student student = studentDAO.findById(studentId);
		student.setFirstName("Test123");
		studentDAO.update(student);

		System.out.println("Updated student: " +  student);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 2;
		System.out.println("Deleting student with id " + studentId);
		studentDAO.deleteById(studentId);
	}

	private int deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		return studentDAO.deleteAll();
	}
}
