package com.example.mycoolapp.repository.employee.impl;

import com.example.mycoolapp.entity.Employee;
import com.example.mycoolapp.repository.employee.EmployeeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return this.entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return this.entityManager.merge(employee);
    }


    @Override
    public void deleteById(int id) {
        Employee employee = this.entityManager.find(Employee.class, id);
        this.entityManager.remove(employee);
    }
}
