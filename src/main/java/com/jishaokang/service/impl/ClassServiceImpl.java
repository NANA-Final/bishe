package com.jishaokang.service.impl;

import com.jishaokang.base.Result;
import com.jishaokang.cache.ResultCache;
import com.jishaokang.dao.ClassDAO;
import com.jishaokang.model.dto.Join;
import com.jishaokang.model.dto.Class;
import com.jishaokang.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDAO classDAO;


    @Override
    public Result addClass(Class class1) {
        classDAO.addClass(class1);
        return ResultCache.OK;
    }

    @Override
    public Result deleteClass(Class class1) {
        classDAO.deleteClass(class1);
        return ResultCache.OK;
    }

    @Override
    public Result selectClassByTeacherId(Class class1) {
        List<Class> classes = classDAO.selectClassByTeacherId(class1);
        return ResultCache.getDataOk(classes);
    }

    @Override
    public Result selectClassByClassId(Class class1) {
        Class classInDB = classDAO.selectClassByClassId(class1);
        return ResultCache.getDataOk(classInDB);
    }

    @Override
    public Result addJoin(Join join) {
        classDAO.addJoin(join);
        return ResultCache.OK;
    }

    @Override
    public Result deleteJoin(Join join) {
        classDAO.deleteJoin(join);
        return ResultCache.OK;
    }

    @Override
    public Result selectClassByUserId(Join join) {
        Join joinInDB = classDAO.selectClassByUserId(join);
        return ResultCache.getDataOk(joinInDB);
    }

    @Override
    public Result selectJoinByClassId(Join join) {
        List<Join> joins = classDAO.selectJoinByClassId(join);
        return ResultCache.getDataOk(joins);
    }
}