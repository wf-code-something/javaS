package com.day.day.up.main.controller;

import com.day.day.up.main.service.FruitService;
import com.day.day.up.main.service.dto.Apple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AllTestController {

    @Autowired
    private FruitService fruitService;

    @RequestMapping("/testCache")
    public String testCache(){

        long id = 2L;
        Apple apple1 = new Apple(id, 3, "test");

        Apple apple = (Apple) fruitService.get(id);
        System.out.println("result1 is " + apple);
        Apple apple3 = (Apple) fruitService.get(id);
        System.out.println("result3 is " + apple3);

        fruitService.put(apple1);

        Apple apple4 = (Apple) fruitService.get(id);
        System.out.println("result4 is " + apple4);

        fruitService.del(id);

        Apple apple5 = (Apple) fruitService.get(id);
        System.out.println("result5 is " + apple5);


        return "Success";
    }
}
