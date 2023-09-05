package com.example.demo.rest;

import com.example.demo.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FunRestController
{
//    inject properties team.name and coach.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/team")
    public String getTeamName(){
        return teamName + " is team of " + coachName;
    }
    @GetMapping("/")
    public String sayHello(){
        return "hello World";
    }

    //expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "run hard edfdf5 kfkf!";
    }
}

