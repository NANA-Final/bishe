package com.jishaokang.dao;

import com.jishaokang.model.dto.Competition;
import com.jishaokang.model.dto.DataFile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Repository
public interface CompetitionDAO {

    List<Competition> selectCompetitionByKeyWord(Competition competition);

    int selectTotalCompetitionByKeyWord(Competition competition);

    Competition selectCompetitionByCompetitionId(Competition competition);

    List<Competition>  selectCompetitionByUserId(Competition competition);

    void insert(Competition competition);

    void delete(Integer competitionId);

    void updateCompetitionContent(Competition competition);

    List<Competition> selectCompetitionByTeacherId(Competition competition);

    List<DataFile> selectDataFileByCompetitionId(DataFile dataFile);

    void addDataFile(DataFile dataFile);

    void deleteDataFile(int dataFileId);

    void incTotalTeam(Integer competitionId);
}
