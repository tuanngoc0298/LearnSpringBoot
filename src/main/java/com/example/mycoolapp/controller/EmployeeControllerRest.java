package com.example.mycoolapp.controller;

import com.example.mycoolapp.entity.Employee;
import com.example.mycoolapp.service.employee.EmployeeService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeControllerRest {
    private JsonMapper jsonMapper;
    private final EmployeeService employeeService;

    public EmployeeControllerRest(EmployeeService employeeService, JsonMapper jsonMapper) {
        this.employeeService = employeeService;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = this.employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee with id: " + employeeId + " not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
       return this.employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        return this.employeeService.save(employee);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee pathEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> pathPayload) {
        Employee employee = this.employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee with id: " + employeeId + " not found");
        }

        if(pathPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body - " + employeeId);
        }

        Employee patchedEmployee = jsonMapper.updateValue(employee, pathPayload);

        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        Employee employee = this.employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee with id: " + employeeId + " not found");
        }
        
        this.employeeService.deleteById(employeeId);
    }
}
