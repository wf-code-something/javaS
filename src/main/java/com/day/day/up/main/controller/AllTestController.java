package com.day.day.up.main.controller;

import com.day.day.up.main.annotation.TimeOut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllTestController {

    @TimeOut
    @GetMapping("/test12")
    public String testTimeOut(){

        System.out.println("this is test12");

        return "Success";
    }
}
