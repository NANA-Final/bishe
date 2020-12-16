package com.jishaokang.service.impl;

import com.jishaokang.base.Result;
import com.jishaokang.cache.ResultCache;
import com.jishaokang.dao.HomeworkDAO;
import com.jishaokang.dao.ScoreDAO;

import com.jishaokang.model.Copy;
import com.jishaokang.model.dto.Competition;
import com.jishaokang.model.dto.Homework;
import com.jishaokang.model.dto.Score;

import com.jishaokang.service.HomeworkService;
import com.jishaokang.service.ScoreService;

import com.jishaokang.util.ScoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    private HomeworkDAO homeworkDAO;
    @Autowired
    private ScoreUtil scoreUtil;

    @Override
    public Result addHomework(Homework homework) {
        homeworkDAO.addHomework(homework);
        return ResultCache.OK;
    }

    @Override
    public Result deleteHomework(Homework homework) {
        homeworkDAO.deleteHomework(homework);
        return ResultCache.OK;
    }

    @Override
    public Result selectHomeworkByClassId(Homework homework) {
        List<Competition> competitions = homeworkDAO.selectHomeworkByClassId(homework);
        return ResultCache.getDataOk(competitions);
    }

    @Override
    public Result selectHomeworkScoreByCompetitionId(Homework homework) throws IOException {
        List<Score> scores = homeworkDAO.selectHomeworkScoreByCompetitionId(homework);
        List<Copy> copies = scoreUtil.checkCopy(scores);
        return ResultCache.getDataOk(copies);
    }
}