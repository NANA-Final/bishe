package com.jishaokang.dao;

import com.jishaokang.model.dto.Class;
import com.jishaokang.model.dto.Join;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Repository
public interface ClassDAO {
    

    void addClass(Class class1);

    void deleteClass(Class class1);

    List<Class> selectClassByTeacherId(Class class1);

    Class selectClassByClassId(Class class1);

    void addJoin(Join join);

    void deleteJoin(Join join);

    Join selectClassByUserId(Join join);

    List<Join> selectJoinByClassId(Join join);
}