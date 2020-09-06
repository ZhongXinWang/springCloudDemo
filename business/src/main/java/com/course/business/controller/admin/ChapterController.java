package com.course.business.controller.admin;

import com.course.server.entity.Chapter;
import com.course.server.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("/list")
    public List<Chapter> list(){
        return chapterService.list();
    }
}
