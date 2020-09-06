package com.course.server.service.impl;

import com.course.server.entity.Chapter;
import com.course.server.entity.ChapterExample;
import com.course.server.mapper.ChapterMapper;
import com.course.server.service.ChapterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*
* @author Winston.Wang
* @date 2020/9/6
* @version 1.0
**/
@Service
public class ChapterServiceImpl implements ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    @Override
    public List<Chapter> list() {
        ChapterExample example = new ChapterExample();
        List<Chapter> chapters = chapterMapper.selectByExample(example);
        return chapters;
    }
}
