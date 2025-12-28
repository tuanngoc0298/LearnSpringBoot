package com.example.mycoolapp.config;

import com.example.mycoolapp.service.coach.CoachService;
import com.example.mycoolapp.service.coach.impl.CricketCoachServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public CoachService cricketCoachServiceImpl() {
        return new CricketCoachServiceImpl();
    }
}
