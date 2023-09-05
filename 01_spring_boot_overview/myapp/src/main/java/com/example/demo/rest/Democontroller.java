package com.example.demo.rest;

import com.example.demo.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Democontroller {
    private Coach myCoach;

    //define a constructor for dependency injection
    @Autowired
    public Democontroller( Coach theCoach) {
        this.myCoach = theCoach;
    }

//    @Autowired
//    public void setTheCoach(Coach theCoach) {
//        this.myCoach = theCoach;
//
//    }
    @GetMapping("/dailywork")
    public String Dailywork(){
        return myCoach.getDailyWorkout();
    }


}
