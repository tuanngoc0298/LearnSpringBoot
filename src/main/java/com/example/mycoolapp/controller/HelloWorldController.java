package com.example.mycoolapp.controller;

import com.example.mycoolapp.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HelloWorldController {
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    // Show Form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // Cach 1: Use HttpServletRequest
    // Process the HTML Form
    //@RequestMapping("/processForm")
    //public String processForm(HttpServletRequest request, Model model) {
    //    // Read the request parameter from the HTML form
    //    String theName = request.getParameter("studentName");
    //
    //    // Convert the data to all caps
    //    theName = theName.toUpperCase();
    //
    //    // Create the message
    //    String result = "Yo! " + theName;
    //
    //    // Add message to the model
    //    model.addAttribute("message", result);
    //
    //    return "helloworld";
    //}

    // Cach 2: Use @RequestParam
    //@PostMapping("/processForm")
    //public String processForm(@RequestParam("studentName") String theName, Model model) {
    //    // Convert the data to all caps
    //    theName = theName.toUpperCase();
    //
    //    // Create the message
    //    String result = "WTF! " + theName;
    //
    //    // Add message to the model
    //    model.addAttribute("message", result);
    //
    //    return "helloworld";
    //}

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model theModel) {
        theModel.addAttribute("student", new Student());
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("languages", languages);
        theModel.addAttribute("systems", systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {
        System.out.println("student: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }
}
