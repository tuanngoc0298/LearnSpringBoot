package com.example.mycoolapp.service.employee.impl;

import com.example.mycoolapp.entity.Employee;
import com.example.mycoolapp.repository.employee.EmployeeJPA;
import com.example.mycoolapp.repository.employee.EmployeeDAO;
import com.example.mycoolapp.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    // Use EntityManager
    private final EmployeeDAO employeeDAO;

    // Use Spring data JPA
    private final EmployeeJPA employeeJPA;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO, EmployeeJPA employeeJPA) {
        this.employeeDAO = employeeDAO;
        this.employeeJPA = employeeJPA;
    }

    @Override
    public List<Employee> findAll() {
        //return this.employeeDAO.findAll();
        return this.employeeJPA.findAllByOrderByLastNameAsc();

    }

    @Override
    public Employee findById(int id) {
        //return this.employeeDAO.findById(id);

        Optional<Employee> result = this.employeeJPA.findById(id);

        Employee theEmployee = null;
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
    }

    @Override
    //@Transactional
    public Employee save(Employee employee) {
        //this.employeeDAO.save(employee);
        return this.employeeJPA.save(employee);
    }


    @Override
    @Transactional
    public void deleteById(int id) {
        //this.employeeDAO.deleteById(id);
        this.employeeJPA.deleteById(id);
    }
}
