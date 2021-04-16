package com.day.day.up.main.guavalimit.controller;

import com.day.day.up.main.design.build.single.TestSingle;
import com.day.day.up.main.guavalimit.annotation.PayRateLimit;
import com.day.day.up.main.guavalimit.enums.LimitKeyTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestSingle testSingle;

    @GetMapping("/test3")
    public String test3() {
        testSingle.testThread();
        return "SUCCESS";
    }

    @GetMapping("/test1")
    @PayRateLimit(perSecond = 1, limitKeyType = LimitKeyTypeEnum.IPADDR)
    public String test1() {
        System.out.println("123");
        return "SUCCESS";
    }

    @GetMapping("/test2")
    @PayRateLimit(perSecond = 1, limitKeyType = LimitKeyTypeEnum.CUSTOM)
    public String test2(String limitKeyValue) {
        return "SUCCESS";
    }
}
