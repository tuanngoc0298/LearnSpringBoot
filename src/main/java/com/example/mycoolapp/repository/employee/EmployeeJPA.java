package com.example.mycoolapp.repository.employee;

import com.example.mycoolapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")
public interface EmployeeJPA extends JpaRepository<Employee, Integer> {
}
