package com.course.server.service.impl;

import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.entity.Chapter;
import com.course.server.entity.ChapterExample;
import com.course.server.mapper.ChapterMapper;
import com.course.server.service.ChapterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public void list(PageDto pageDto) {
        // 分页
        PageHelper.startPage(pageDto.getPageNum(),pageDto.getPageSize());
        ChapterExample example = new ChapterExample();
        List<Chapter> chapters = chapterMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(chapters);
        List<ChapterDto> chapterDtos = new ArrayList<>();
        if(!CollectionUtils.isEmpty(chapters)){
            chapters.forEach(item->{
                ChapterDto chapterDto = new ChapterDto();
                BeanUtils.copyProperties(item,chapterDto);
                chapterDtos.add(chapterDto);
            });
        }
        pageDto.setTotal(pageInfo.getTotal());
        pageDto.setList(chapterDtos);
    }
}
