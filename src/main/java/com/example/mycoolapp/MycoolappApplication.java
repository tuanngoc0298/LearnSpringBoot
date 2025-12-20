package com.example.mycoolapp;

import com.example.mycoolapp.entity.Student;
import com.example.mycoolapp.repository.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
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
}
