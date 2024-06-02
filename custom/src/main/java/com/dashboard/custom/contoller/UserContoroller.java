package com.dashboard.custom.contoller;

import com.dashboard.custom.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/user")
public class UserContoroller {

    @Autowired
    private TestService testService;

    @GetMapping
    public String authCheck() {
        return "return yes";
    }

    @PostMapping(value = "login", produces = "application/json; charset=utf-8")
    public Map<String, String> login(@RequestBody Map<String, String> map) {
        return map;
    }

}
