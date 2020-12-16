package com.jishaokang.dao;


import com.jishaokang.model.dto.Score;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Repository
public interface ScoreDAO {


    void addScore(Score score);

    List<Score> selectScoreByCompetitionId(Score score);

    List<Score>  selectScoreByCompetitionIdAndUserId(Score score);


}