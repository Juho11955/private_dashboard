package com.dashboard.custom.contoller;

import com.dashboard.custom.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;
    @GetMapping
    public void MapperCallTest(){
        System.out.println("TestController.MapperCallTest");
        testService.call();
    }
}
