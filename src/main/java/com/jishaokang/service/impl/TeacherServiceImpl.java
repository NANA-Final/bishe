package com.jishaokang.service.impl;

import com.jishaokang.base.Result;
import com.jishaokang.cache.ResultCache;
import com.jishaokang.dao.TeacherDAO;
import com.jishaokang.model.dto.Teacher;
import com.jishaokang.service.TeacherService;
import com.jishaokang.util.EncyptUtil;
import com.jishaokang.util.VerificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


/**
 * Created by NANA_Final on 2020/3/21.
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDAO teacherDAO;
    @Autowired
    private VerificationUtil verificationUtil;

    @Override
    public Result login(Teacher teacher, HttpSession session) throws NoSuchAlgorithmException {
        String passwordInDB = teacherDAO.selectPasswordByPhone(teacher.getPhone());
        if (passwordInDB == null) {
            return ResultCache.getDataError(501,"用户不存在");
        }else if (EncyptUtil.encyptPassword(teacher.getPassword()).equals(passwordInDB)){
            Teacher teacherInDB = teacherDAO.selectByPhone(teacher.getPhone());
            session.setAttribute("teacherId",teacherInDB.getTeacherId());
            return ResultCache.getDataOk(teacherInDB);
        }else{
            return ResultCache.getDataError(502,"用户名或密码错误");
        }
    }

    @Override
    public Result addTeacher(Teacher teacher) throws NoSuchAlgorithmException {
        if (!verificationUtil.checkVerification(teacher.getPhone(),teacher.getVerification())) {
            return ResultCache.getDataError(501, "验证码错误");
        }
        teacher.setPassword(EncyptUtil.encyptPassword(teacher.getPassword()));
        teacherDAO.insert(teacher);
        return ResultCache.OK;
    }

    @Override
    public Result sendVerification(Teacher teacher) throws IOException {
        verificationUtil.sendVerification(teacher.getPhone());
        return ResultCache.OK;
    }

    @Override
    public Result logout(Teacher teacher, HttpSession session) {
        session.setAttribute("teacherId",null);
        return ResultCache.OK;
    }

    @Override
    public Result getTeacherCurrent(HttpSession session) {
        int teacherId = Integer.parseInt(session.getAttribute("teacherId").toString());
        Teacher teacher = teacherDAO.selectByTeacherId(teacherId);
        return ResultCache.getDataOk(teacher);
    }

    @Override
    public Result updateTeacherPassword(Teacher teacher) throws NoSuchAlgorithmException {
        if (!verificationUtil.checkVerification(teacher.getPhone(),teacher.getVerification())) {
            return ResultCache.getDataError(501, "验证码错误");
        }
        teacher.setPassword(EncyptUtil.encyptPassword(teacher.getPassword()));
        teacherDAO.updatePassword(teacher);
        return ResultCache.OK;
    }


    @Override
    public Result updatePhone(Teacher teacher) {
        if (!verificationUtil.checkVerification(teacher.getPhone(),teacher.getVerification())){
            return ResultCache.getDataError(501,"验证码输入错误");
        }
        teacherDAO.updatePhone(teacher);
        return ResultCache.OK;
    }

    @Override
    public Result updateTeacherName(Teacher teacher) {
        teacherDAO.updateTeacherName(teacher);
        return ResultCache.OK;
    }


}