package com.dashboard.custom.service;

import com.dashboard.custom.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

   @Autowired
   private TestMapper testMapper;

    public void call() {
        System.out.println("TestService.call!!");
        Object call = testMapper.call();
        System.out.println("call = " + call);

    }
}
