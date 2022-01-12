package com.example.springbootdemo.aspect;

import com.example.springbootdemo.aspect.service.NeedAspectService;
import com.example.springbootdemo.transation.entity.Test2;
import com.example.springbootdemo.transation.mapper.Test2Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AspectTest {

    @Autowired
    NeedAspectService needAspectService;

    @Autowired
    Test2Mapper test2Mapper;

    @Test
    void contextLoads() {
        needAspectService.log("sqs");
    }

}
