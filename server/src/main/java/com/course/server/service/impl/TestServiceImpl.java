package com.course.server.service.impl;


import com.course.server.entity.Test;
import com.course.server.mapper.TestMapper;
import com.course.server.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* 测试服务层
* @author Winston.Wang
* @date 2020/8/9
* @version 1.0
**/
@Service
public class TestServiceImpl  implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public List<Test> list() {
        return testMapper.selectByExample(null);
    }
}
