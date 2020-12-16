package com.jishaokang.controller;

import com.jishaokang.base.Result;
import com.jishaokang.cache.ResultCache;
import com.jishaokang.model.dto.Discuss;

import com.jishaokang.service.DiscussService;
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
public class DiscussController {

    @Autowired
    private DiscussService discussService;

    //------------------------------------------------------------------
    @RequestMapping(value = "/user/discuss/addDiscuss",method = RequestMethod.POST)
    public Result addDiscuss(@RequestBody Discuss discuss) {
        return discussService.addDiscuss(discuss);
    }

    @RequestMapping(value = "/all/discuss/selectDiscussByCompetitionId",method = RequestMethod.POST)
    public Result selectDiscussByCompetitionId(@RequestBody Discuss discuss) {
        return discussService.selectDiscussByCompetitionId(discuss);
    }

    @RequestMapping(value = "/user/discuss/selectDiscussByUserId",method = RequestMethod.POST)
    public Result selectDiscussByUserId(@RequestBody Discuss discuss) {
        return discussService.selectDiscussByUserId(discuss);
    }

    @RequestMapping(value = "/all/discuss/selectDiscussByKeyWord",method = RequestMethod.POST)
    public Result selectDiscussByKeyWord(@RequestBody Discuss discuss) {
        return discussService.selectDiscussByKeyWord(discuss);
    }

    @RequestMapping(value = "/all/discuss/selectDiscuss",method = RequestMethod.POST)
    public Result selectDiscuss(@RequestBody Discuss discuss) {
        return discussService.selectDiscuss(discuss);
    }

    @RequestMapping(value = "/all/discuss/selectDiscussByDiscussId",method = RequestMethod.POST)
    public Result selectDiscussByDiscussId(@RequestBody Discuss discuss) {
        return discussService.selectDiscussByDiscussId(discuss);
    }
}