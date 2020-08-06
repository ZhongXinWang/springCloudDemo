package com.course.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
* 测试控制层
* @author Winston.Wang
* @date 2020/8/6
* @version 1.0
**/
@RestController
public class TestController {

    @ResponseBody
    @GetMapping("/")
    public  String index(){
        return "HelloWorld";
    }
}
