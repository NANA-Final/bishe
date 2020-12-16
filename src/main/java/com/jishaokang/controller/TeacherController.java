package com.jishaokang.controller;

import com.jishaokang.base.Result;
import com.jishaokang.model.dto.Teacher;
import com.jishaokang.model.dto.Teacher;
import com.jishaokang.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

/**
 * Created by NANA_Final on 2020/3/21.
 */
@RestController
@RequestMapping(value = "/api")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //------------------------------------------
    @RequestMapping(value = "/all/teacher/login",method = RequestMethod.POST)
    public Result teacherLogin(@RequestBody Teacher teacher, HttpSession session) throws NoSuchAlgorithmException {
        return teacherService.login(teacher,session);
    }

    @RequestMapping(value = "/all/teacher/addTeacher",method = RequestMethod.POST)
    public Result addTeacher(@RequestBody Teacher teacher) throws NoSuchAlgorithmException {
        return teacherService.addTeacher(teacher);
    }
    @RequestMapping(value = "/all/teacher/sendVerification",method = RequestMethod.POST)
    public Result sendVerification(@RequestBody Teacher teacher) throws IOException {
        return teacherService.sendVerification(teacher);
    }

    @RequestMapping(value = "/teacher/teacher/logout",method = RequestMethod.POST)
    public Result teacherLogout(@RequestBody Teacher teacher, HttpSession session) {
        return teacherService.logout(teacher,session);
    }

    @RequestMapping(value = "/teacher/teacher/getTeacherCurrent",method = RequestMethod.POST)
    public Result getTeacherCurrent(HttpSession session) {
        return teacherService.getTeacherCurrent(session);
    }

    @RequestMapping(value = "/teacher/teacher/updateTeacherPassword",method = RequestMethod.POST)
    public Result updateTeacherPassword(@RequestBody Teacher teacher) throws NoSuchAlgorithmException {
        return teacherService.updateTeacherPassword(teacher);
    }

    @RequestMapping(value = "/teacher/teacher/updatePhone",method = RequestMethod.POST)
    public Result updatePhone(@RequestBody Teacher teacher){
        return teacherService.updatePhone(teacher);
    }

    @RequestMapping(value = "/teacher/teacher/updateTeacherName",method = RequestMethod.POST)
    public Result updateTeacherName(@RequestBody Teacher teacher) {
        return teacherService.updateTeacherName(teacher);
    }



}