package com.example.mycoolapp.controller;

import com.example.mycoolapp.entity.Employee;
import com.example.mycoolapp.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeControllerMVC {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeControllerMVC(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);

        return "employees/list-employees";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int employeeId, Model model) {
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int employeeId) {
        employeeService.deleteById(employeeId);
        return "redirect:/employees/list";
    }
}
