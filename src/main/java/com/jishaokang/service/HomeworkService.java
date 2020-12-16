package com.jishaokang.service;

import com.jishaokang.base.Result;

import com.jishaokang.model.dto.Homework;
import com.jishaokang.model.dto.Score;

import java.io.IOException;

/**
 * Created by NANA_Final on 2019/6/21.
 */
public interface HomeworkService {


    Result addHomework(Homework homework);

    Result deleteHomework(Homework homework);

    Result selectHomeworkByClassId(Homework homework);

    Result selectHomeworkScoreByCompetitionId(Homework homework) throws IOException;

}
