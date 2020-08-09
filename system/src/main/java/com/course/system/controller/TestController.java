package com.course.system.controller;

import com.course.server.entity.Test;
import com.course.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* 测试控制层
* @author Winston.Wang
* @date 2020/8/6
* @version 1.0
**/
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/")
    public List<Test> index(){
        return testService.list();
    }
}
