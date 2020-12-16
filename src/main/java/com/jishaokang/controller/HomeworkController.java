package com.jishaokang.controller;

import com.jishaokang.base.Result;
import com.jishaokang.cache.ResultCache;
import com.jishaokang.model.dto.Homework;

import com.jishaokang.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@RestController
@RequestMapping(value = "/api")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    //------------------------------------------------------------------
    @RequestMapping(value = "/teacher/homework/addHomework",method = RequestMethod.POST)
    public Result addHomework(@RequestBody Homework homework) {
        return homeworkService.addHomework(homework);
    }

    @RequestMapping(value = "/teacher/homework/deleteHomework",method = RequestMethod.POST)
    public Result deleteHomework(@RequestBody Homework homework) {
        return homeworkService.deleteHomework(homework);
    }

    @RequestMapping(value = "/all/homework/selectHomeworkByClassId",method = RequestMethod.POST)
    public Result selectHomeworkByClassId(@RequestBody Homework homework) {
        return homeworkService.selectHomeworkByClassId(homework);
    }

    @RequestMapping(value = "/teacher/homework/selectHomeworkScoreByCompetitionId",method = RequestMethod.POST)
    public Result selectHomeworkScoreByCompetitionId(@RequestBody Homework homework) throws IOException {
        return homeworkService.selectHomeworkScoreByCompetitionId(homework);
    }


}