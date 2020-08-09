package com.course.system.controller;

import com.course.system.entity.Test;
import com.course.system.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* 测试控制层
* @author Winston.Wang
* @date 2020/8/6
* @version 1.0
**/
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/")
    public List<Test> index(){
        return testService.list();
    }
}
