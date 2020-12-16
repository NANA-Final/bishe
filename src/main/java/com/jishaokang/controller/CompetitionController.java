package com.jishaokang.controller;

import com.jishaokang.base.Result;
import com.jishaokang.cache.ResultCache;
import com.jishaokang.model.dto.Competition;
import com.jishaokang.model.dto.DataFile;
import com.jishaokang.model.dto.User;
import com.jishaokang.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * Created by NANA_Final on 2020/3/21.
 */
@RestController
@RequestMapping(value = "/api")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    //----------------------------------------------
    @RequestMapping(value = "/all/competition/selectCompetitionByKeyWord",method = RequestMethod.POST)
    public Result selectCompetitionByKeyWord(@RequestBody Competition competition) {
        return competitionService.selectCompetitionByKeyWord(competition);
    }

    @RequestMapping(value = "/all/competition/selectCompetitionByCompetitionId",method = RequestMethod.POST)
    public Result selectCompetitionByCompetitionId(@RequestBody Competition competition) {
        return competitionService.selectCompetitionByCompetitionId(competition);
    }

    @RequestMapping(value = "/user/competition/selectCompetitionByUserId",method = RequestMethod.POST)
    public Result selectRealCompetitionByCompetitionId(@RequestBody Competition competition) {
        return competitionService.selectCompetitionByUserId(competition);
    }

    //-------------------------------------------------------

    @RequestMapping(value = "/teacher/competition/addCompetition",method = RequestMethod.POST)
    public Result addCompetition(@RequestBody Competition competition) {
        return competitionService.addCompetition(competition);
    }

    @RequestMapping(value = "/teacher/competition/updateCompetitionContent",method = RequestMethod.POST)
    public Result updateCompetitionContent(@RequestBody Competition competition) {
        return competitionService.updateCompetitionContent(competition);
    }

    @RequestMapping(value = "/teacher/competition/deleteCompetition",method = RequestMethod.POST)
    public Result deleteCompetition(@RequestBody Competition competition) {
        return competitionService.deleteCompetition(competition.getCompetitionId());
    }

    @RequestMapping(value = "/teacher/competition/selectCompetitionByTeacherId",method = RequestMethod.POST)
    public Result selectCompetitionByTeacherId(@RequestBody Competition competition) {
        return competitionService.selectCompetitionByTeacherId(competition);
    }

    //----------------------------------------------------------------------------
    @RequestMapping(value = "/all/competition/selectDataFileByCompetitionId",method = RequestMethod.POST)
    public Result selectDataFileByCompetitionId(@RequestBody DataFile dataFile) {
        return competitionService.selectDataFileByCompetitionId(dataFile);
    }

    @RequestMapping(value = "/teacher/competition/addDataFile",method = RequestMethod.POST)
    public Result addDataFile(@RequestBody DataFile dataFile) {
        return competitionService.addDataFile(dataFile);
    }

    @RequestMapping(value = "/teacher/competition/deleteDataFile",method = RequestMethod.POST)
    public Result deleteDataFile(@RequestBody DataFile dataFile) {
        return competitionService.deleteDataFile(dataFile);
    }

    @RequestMapping(value = "/teacher/competition/uploadDataFile",method = RequestMethod.POST)
    public Result uploadDataFile(MultipartFile dataFile, HttpServletRequest request) throws IOException {

        String path = request.getServletContext().getRealPath("/upload/dataFile/");
        String fileName = dataFile.getOriginalFilename()+" (DataX"+new Date().getTime()+")";
        File targetFile = new File(path, fileName);
        targetFile.createNewFile();
        try {
            dataFile.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultCache.getDataOk("upload/dataFile/"+fileName);
    }


}