package com.example.mycoolapp.repository.employee;

import com.example.mycoolapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")
public interface EmployeeJPA extends JpaRepository<Employee, Integer> {
    // Add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
