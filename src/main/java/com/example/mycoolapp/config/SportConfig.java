package com.example.mycoolapp.config;

import com.example.mycoolapp.service.CoachService;
import com.example.mycoolapp.service.Impl.CricketCoachServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class SportConfig {
    @Bean
    public CoachService cricketCoachServiceImpl() {
        return new CricketCoachServiceImpl();
    }
}
