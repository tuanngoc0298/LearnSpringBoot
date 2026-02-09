package com.example.mycoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome() {
        return "project1/home";
    }

    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "project1/plain-login";
    }

    @GetMapping("/leaders")
    public String showLeaders() {
        return "project1/leaders";
    }

}
