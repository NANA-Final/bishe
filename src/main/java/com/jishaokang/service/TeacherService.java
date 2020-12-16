package com.jishaokang.service;

import com.jishaokang.base.Result;
import com.jishaokang.model.dto.Teacher;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

/**
 * Created by NANA_Final on 2020/3/21.
 */
public interface TeacherService {
    Result login(Teacher teacher, HttpSession session) throws NoSuchAlgorithmException;

    Result addTeacher(Teacher teacher) throws NoSuchAlgorithmException;

    Result sendVerification(Teacher teacher) throws IOException;

    Result logout(Teacher teacher, HttpSession session);

    Result getTeacherCurrent(HttpSession session);

    Result updateTeacherPassword(Teacher teacher) throws NoSuchAlgorithmException;

    Result updatePhone(Teacher teacher);

    Result updateTeacherName(Teacher teacher);

}
