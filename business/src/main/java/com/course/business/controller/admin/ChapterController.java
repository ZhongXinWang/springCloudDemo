package com.course.business.controller.admin;

import com.course.server.dto.PageDto;
import com.course.server.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 大章controller
* @author Winston.Wang
* @date 2020/9/6
* @version 1.0
**/
@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    /**
     * 获取列表
     * @param pageDto
     * @return
     */
    @RequestMapping("/list")
    public PageDto list(@RequestBody  PageDto pageDto){

        chapterService.list(pageDto);

        return pageDto;
    }
}
