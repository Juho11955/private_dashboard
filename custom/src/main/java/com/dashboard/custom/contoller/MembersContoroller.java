package com.dashboard.custom.contoller;

import com.dashboard.custom.service.TestService;
import com.dashboard.custom.service.members.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/members")
public class MembersContoroller {

    @Autowired
    private MembersService membersService;

    @GetMapping
    public String authCheck() {
        return "return yes";
    }

    @PostMapping(value = "signin", produces = "application/json; charset=utf-8")
    public Map<String, String> login(@RequestBody Map<String, String> map) {
        return map;
    }

    @PostMapping(value = "test", produces = "application/json; charset=utf-8")
    public Map<String, String> test(@RequestBody Map<String, String> map) {
        return map;
    }


}
