package com.course.server.service;

import com.course.server.dto.PageDto;

/**
* 大章服务接口
* @author Winston.Wang
* @date 2020/9/6
* @version 1.0
**/
public interface ChapterService {

    void list(PageDto pageDto);

}
