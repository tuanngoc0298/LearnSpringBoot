package com.example.mycoolapp.config;

import com.example.mycoolapp.service.CoachService;
import com.example.mycoolapp.service.impl.CricketCoachServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public CoachService cricketCoachServiceImpl() {
        return new CricketCoachServiceImpl();
    }
}
