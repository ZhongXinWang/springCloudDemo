package com.course.business.controller.admin;

import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.ChapterService;
import com.course.server.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 大章controller
* @author Winston.Wang
* @date 2020/9/6
* @version 1.0
**/
@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    public static final String BUSINESS_NAME="大章";

    @Autowired
    private ChapterService chapterService;

    /**
     * 获取列表
     * @param pageDto
     * @return
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody  PageDto pageDto){

        chapterService.list(pageDto);
        return ResponseDto.builder()
                .isSuccess(true)
                .code(200)
                .content(pageDto)
                .build();
    }

    /**
     * 保存数据
     * @param chapter
     * @return
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody  ChapterDto chapter){
        // 保存校验
        ValidatorUtil.require(chapter.getName(), "名称");
        ValidatorUtil.require(chapter.getCourseId(), "课程ID");
        ValidatorUtil.length(chapter.getCourseId(), "课程ID", 1, 8);

        chapterService.save(chapter);
        return ResponseDto.builder()
                .isSuccess(true)
                .code(200)
                .msg("保存成功")
                .build();
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable  String id){

        chapterService.delete(id);
        return ResponseDto.builder()
                .isSuccess(true)
                .code(200)
                .msg("删除成功")
                .build();
    }

}
