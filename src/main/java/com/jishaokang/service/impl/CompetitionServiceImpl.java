package com.jishaokang.service.impl;

import com.jishaokang.base.Result;
import com.jishaokang.cache.ResultCache;
import com.jishaokang.dao.CompetitionDAO;
import com.jishaokang.model.dto.Competition;
import com.jishaokang.model.dto.DataFile;
import com.jishaokang.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionDAO competitionDAO;

    @Override
    public Result selectCompetitionByKeyWord(Competition competition) {
        int total = competitionDAO.selectTotalCompetitionByKeyWord(competition);
        List<Competition> competitions = competitionDAO.selectCompetitionByKeyWord(competition);
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        for (Competition c : competitions) {
            Date date =new Date();
            String dateString = sdf.format(date);
            if (dateString.compareTo(c.getEndTime())>=0) c.setTimeState(0); else c.setTimeState(1);
        }
        return ResultCache.getListDataOk(total,"competitions",competitions);
    }

    @Override
    public Result selectCompetitionByCompetitionId(Competition competition) {
        Competition competitionInDB = competitionDAO.selectCompetitionByCompetitionId(competition);
        Date date =new Date();
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String dateString = sdf.format(date);
        if (dateString.compareTo(competitionInDB.getEndTime())>=0) competitionInDB.setTimeState(0); else competitionInDB.setTimeState(1);
        return ResultCache.getDataOk(competitionInDB);
    }

    @Override
    public Result selectCompetitionByUserId(Competition competition) {
        List<Competition> competitions = competitionDAO.selectCompetitionByUserId(competition);
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        for (Competition c : competitions) {
            Date date =new Date();
            String dateString = sdf.format(date);
            if (dateString.compareTo(c.getEndTime())>=0) c.setTimeState(0); else c.setTimeState(1);
        }
        return ResultCache.getDataOk(competitions);
    }

    @Override
    public Result addCompetition(Competition competition) {
        competitionDAO.insert(competition);
        return ResultCache.OK;
    }

    @Override
    public Result deleteCompetition(int competitionId) {
        competitionDAO.delete(competitionId);
        return ResultCache.OK;
    }

    @Override
    public Result updateCompetitionContent(Competition competition) {
        competitionDAO.updateCompetitionContent(competition);
        return ResultCache.OK;
    }

    @Override
    public Result selectCompetitionByTeacherId(Competition competition) {
        List<Competition> competitions = competitionDAO.selectCompetitionByTeacherId(competition);
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        for (Competition c : competitions) {
            Date date =new Date();
            String dateString = sdf.format(date);
            if (dateString.compareTo(c.getEndTime())>=0) c.setTimeState(0); else c.setTimeState(1);
        }
        return ResultCache.getDataOk(competitions);
    }

    @Override
    public Result selectDataFileByCompetitionId(DataFile dataFile) {
        List<DataFile> dataFiles = competitionDAO.selectDataFileByCompetitionId(dataFile);
        return ResultCache.getDataOk(dataFiles);
    }

    @Override
    public Result addDataFile(DataFile dataFile) {
        competitionDAO.addDataFile(dataFile);
        return ResultCache.OK;
    }

    @Override
    public Result deleteDataFile(DataFile dataFile) {
        competitionDAO.deleteDataFile(dataFile.getDataFileId());
        return ResultCache.OK;
    }


}