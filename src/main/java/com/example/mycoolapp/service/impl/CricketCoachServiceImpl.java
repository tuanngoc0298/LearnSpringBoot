package com.example.mycoolapp.service.impl;

import com.example.mycoolapp.service.CoachService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoachServiceImpl implements CoachService {
    @Override
    public String getDailyWorkout() {
        return "Get daily coach";
    }
}
