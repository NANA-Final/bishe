package com.jishaokang.dao;

import com.jishaokang.model.dto.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NANA_Final on 2020/3/21.
 */
@Repository
public interface TeacherDAO {
    String selectPasswordByPhone(String phone);

    Teacher selectByPhone(String phone);

    void insert(Teacher teacher);

    Teacher selectByTeacherId(int teacherId);

    void updatePassword(Teacher teacher);

    void updatePhone(Teacher teacher);

    void updateTeacherName(Teacher teacher);

}
