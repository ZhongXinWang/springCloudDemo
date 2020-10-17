package com.course.server.service.impl;

import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.entity.Chapter;
import com.course.server.entity.ChapterExample;
import com.course.server.mapper.ChapterMapper;
import com.course.server.service.ChapterService;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
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
    public void list(PageDto pageDto) {
        // 分页
        PageHelper.startPage(pageDto.getPageNum(),pageDto.getPageSize());
        ChapterExample example = new ChapterExample();
        List<Chapter> chapters = chapterMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(chapters);
        List<ChapterDto> chapterDtos = CopyUtil.copyList(chapters,ChapterDto.class);
        pageDto.setTotal(pageInfo.getTotal());
        pageDto.setList(chapterDtos);
    }

    /**
     * 新增/编辑入口
     * @param chapterDto
     */
    @Override
    public void save(ChapterDto chapterDto) {
        Chapter chapter = CopyUtil.copy(chapterDto, Chapter.class);
        //新增
        if(StringUtil.isEmpty(chapter.getId())){
            chapter.setId(UuidUtil.getShortUuid());
            chapterMapper.insertSelective(chapter);
        }else{
            chapterMapper.updateByPrimaryKey(chapter);
        }
    }

    /**
     * 删除方法
     * @param id
     */
    @Override
    public void delete(String id) {
        chapterMapper.deleteByPrimaryKey(id);
    }

}
