package com.dashboard.custom.contoller;

import com.dashboard.custom.DTO.JwtTokenDTO;
import com.dashboard.custom.DTO.LoginDTO;
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

    @PostMapping(value = "login", produces = "application/json; charset=utf-8")
    public JwtTokenDTO login(@RequestBody LoginDTO loginDTO) {
        String memberEmail = loginDTO.getMemberEmail();
        String memberPw = loginDTO.getMemberPw();
        JwtTokenDTO jwtTokenDTO = membersService.login(memberEmail, memberPw);
        return jwtTokenDTO;
    }


    @PostMapping(value = "signin", produces = "application/json; charset=utf-8")
    public Map<String, String> login(@RequestBody Map<String, String> map) {
        return map;
    }

    @GetMapping(value = "test", produces = "application/json; charset=utf-8")
    public String test() {
        System.out.println("test");
        return "test";
    }


}
