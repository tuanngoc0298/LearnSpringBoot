package com.example.mycoolapp.service.employee.impl;

import com.example.mycoolapp.entity.Employee;
import com.example.mycoolapp.repository.employee.EmployeeDAO;
import com.example.mycoolapp.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        this.employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        return this.employeeDAO.update(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        this.employeeDAO.deleteById(id);
    }
}
