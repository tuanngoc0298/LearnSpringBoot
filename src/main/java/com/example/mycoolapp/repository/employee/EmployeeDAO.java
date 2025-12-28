package com.example.mycoolapp.repository.employee;

import com.example.mycoolapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    Employee update(Employee employee);
    void deleteById(int id);
}
