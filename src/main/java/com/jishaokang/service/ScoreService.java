package com.jishaokang.service;

import com.jishaokang.base.Result;

import com.jishaokang.model.dto.Score;

import java.io.IOException;

/**
 * Created by NANA_Final on 2019/6/21.
 */
public interface ScoreService {

    Result addScore(Score score) throws IOException;

    Result selectScoreByCompetitionId(Score score);

    Result selectScoreByCompetitionIdAndUserId(Score score);
}
