package com.example.mycoolapp.service.Impl;

import com.example.mycoolapp.service.CoachService;
import org.springframework.stereotype.Component;

@Component
public class CricketCoachServiceImpl implements CoachService {
    @Override
    public String getDailyWorkout() {
        return "Get daily coach";
    }
}
