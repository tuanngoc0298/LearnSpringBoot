package com.example.mycoolapp.controller;

import com.example.mycoolapp.service.coach.CoachService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private final CoachService coachService;

    @Autowired
    public CoachController(
           @Qualifier("cricketCoachServiceImpl") CoachService coachService
    ) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.coachService = coachService;
    }

    @PostConstruct
    public void init() {
        System.out.println("In postConstruct: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("In preDestroy: " + getClass().getSimpleName());
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coachService.getDailyWorkout();
    }
}
