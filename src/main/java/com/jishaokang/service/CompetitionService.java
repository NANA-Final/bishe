package com.jishaokang.service;

import com.jishaokang.base.Result;
import com.jishaokang.model.dto.Competition;
import com.jishaokang.model.dto.DataFile;

/**
 * Created by NANA_Final on 2019/6/21.
 */
public interface CompetitionService {

    Result selectCompetitionByKeyWord(Competition competition);

    Result selectCompetitionByCompetitionId(Competition competition);
    
    Result selectCompetitionByUserId(Competition competition);




    Result addCompetition(Competition competition);

    Result deleteCompetition(int competitionId);

    Result updateCompetitionContent(Competition competition);

    Result selectCompetitionByTeacherId(Competition competition);


    Result selectDataFileByCompetitionId(DataFile dataFile);

    Result addDataFile(DataFile dataFile);

    Result deleteDataFile(DataFile dataFile);
}
