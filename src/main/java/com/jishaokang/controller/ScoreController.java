package com.jishaokang.controller;

import com.jishaokang.base.Result;
import com.jishaokang.cache.ResultCache;
import com.jishaokang.model.dto.Score;

import com.jishaokang.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@RestController
@RequestMapping(value = "/api")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    //------------------------------------------------------------------
    @RequestMapping(value = "/user/score/addScore",method = RequestMethod.POST)
    public Result addScore(@RequestBody Score score) throws IOException {
        return scoreService.addScore(score);
    }

    @RequestMapping(value = "/all/score/selectScoreByCompetitionId",method = RequestMethod.POST)
    public Result selectScoreByCompetitionId(@RequestBody Score score) {
        return scoreService.selectScoreByCompetitionId(score);
    }

    @RequestMapping(value = "/user/score/selectScoreByCompetitionIdAndUserId",method = RequestMethod.POST)
    public Result selectScoreByCompetitionIdAndUserId(@RequestBody Score score) {
        return scoreService.selectScoreByCompetitionIdAndUserId(score);
    }

    @RequestMapping(value = "/user/score/uploadCoreFile",method = RequestMethod.POST)
    public Result uploadCoreFile(MultipartFile dataFile, HttpServletRequest request) throws IOException {

        String path = request.getServletContext().getRealPath("/upload/coreFile/");
        String fileName = dataFile.getOriginalFilename()+" (DataX"+new Date().getTime()+")";
        File targetFile = new File(path, fileName);
        targetFile.createNewFile();
        try {
            dataFile.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultCache.getDataOk("upload/coreFile/"+fileName);
    }

    @RequestMapping(value = "/user/score/uploadScoreFile",method = RequestMethod.POST)
    public Result uploadScoreFile(MultipartFile dataFile, HttpServletRequest request) throws IOException {

        String path = request.getServletContext().getRealPath("/upload/scoreFile/");
        String fileName = dataFile.getOriginalFilename()+" (DataX"+new Date().getTime()+")";
        File targetFile = new File(path, fileName);
        targetFile.createNewFile();
        try {
            dataFile.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultCache.getDataOk("upload/scoreFile/"+fileName);
    }

}