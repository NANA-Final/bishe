package com.jishaokang.controller;

import com.jishaokang.base.Result;
import com.jishaokang.model.dto.Class;
import com.jishaokang.model.dto.Join;
import com.jishaokang.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by NANA_Final on 2019/6/21.
 */

@RestController
@RequestMapping(value = "/api")
public class ClassController {

    @Autowired
    private ClassService classService;

    @RequestMapping(value = "/teacher/class/addClass",method = RequestMethod.POST)
    public Result addClass(@RequestBody Class class1) {
        return classService.addClass(class1);
    }

    @RequestMapping(value = "/teacher/class/deleteClass",method = RequestMethod.POST)
    public Result deleteClass(@RequestBody Class class1) {
        return classService.deleteClass(class1);
    }

    @RequestMapping(value = "/teacher/class/selectClassByTeacherId",method = RequestMethod.POST)
    public Result selectClassByTeacherId(@RequestBody Class class1) {
        return classService.selectClassByTeacherId(class1);
    }

    @RequestMapping(value = "/all/class/selectClassByClassId",method = RequestMethod.POST)
    public Result selectClassByClassId(@RequestBody Class class1) {
        return classService.selectClassByClassId(class1);
    }



    @RequestMapping(value = "/user/join/addJoin",method = RequestMethod.POST)
    public Result addJoin(@RequestBody Join join) {
        return classService.addJoin(join);
    }

    @RequestMapping(value = "/user/join/deleteJoin",method = RequestMethod.POST)
    public Result deleteJoin(@RequestBody Join join) {
        return classService.deleteJoin(join);
    }

    @RequestMapping(value = "/all/join/selectJoinByUserId",method = RequestMethod.POST)
    public Result selectClassByUserId(@RequestBody Join join) {
        return classService.selectClassByUserId(join);
    }

    @RequestMapping(value = "/examiner/join/selectJoinByClassId",method = RequestMethod.POST)
    public Result selectJoinByClassId(@RequestBody Join join) {
        return classService.selectJoinByClassId(join);
    }
}