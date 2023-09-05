package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component  //makes available for dependency injection
@Primary
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Fast bowling ";
    }
}
