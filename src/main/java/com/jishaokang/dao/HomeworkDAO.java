package com.jishaokang.dao;


import com.jishaokang.model.dto.Competition;
import com.jishaokang.model.dto.Homework;
import com.jishaokang.model.dto.Score;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Repository
public interface HomeworkDAO {


    void addHomework(Homework homework);

    void deleteHomework(Homework homework);

    List<Competition> selectHomeworkByClassId(Homework homework);

    List<Score> selectHomeworkScoreByCompetitionId(Homework homework);
}