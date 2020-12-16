package com.jishaokang.service.impl;

import com.jishaokang.base.Result;
import com.jishaokang.cache.ResultCache;
import com.jishaokang.dao.CompetitionDAO;
import com.jishaokang.dao.ScoreDAO;

import com.jishaokang.model.dto.Score;

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
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDAO scoreDAO;
    @Autowired
    private CompetitionDAO competitionDAO;
    @Autowired
    private ScoreUtil scoreUtil;


    @Override
    public Result addScore(Score score) throws IOException {
        scoreDAO.addScore(score);
        score.setScore(scoreUtil.countScore(score.getSubmitCodeUrl(),score.getSubmitFileUrl()));
        if (scoreDAO.selectScoreByCompetitionIdAndUserId(score).size() == 0){
            competitionDAO.incTotalTeam(score.getCompetitionId());
        }
        return ResultCache.OK;
    }

    @Override
    public Result selectScoreByCompetitionId(Score score) {
        List<Score> scores = scoreDAO.selectScoreByCompetitionId(score);
        return ResultCache.getDataOk(scores);
    }

    @Override
    public Result selectScoreByCompetitionIdAndUserId(Score score) {
        List<Score> scoreInDB = scoreDAO.selectScoreByCompetitionIdAndUserId(score);
        return ResultCache.getDataOk(scoreInDB);
    }
}