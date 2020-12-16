package com.jishaokang.service;

import com.jishaokang.base.Result;
import com.jishaokang.model.dto.Class;
import com.jishaokang.model.dto.Join;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by NANA_Final on 2019/6/21.
 */
public interface ClassService {

    Result addClass(Class class1);

    Result deleteClass(Class class1);

    Result selectClassByTeacherId(Class class1);

    Result selectClassByClassId(Class class1);

    Result addJoin(Join join);

    Result deleteJoin(Join join);

    Result selectClassByUserId(Join join);

    Result selectJoinByClassId(Join join);
}
