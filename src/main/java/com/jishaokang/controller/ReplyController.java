package com.jishaokang.controller;

import com.jishaokang.base.Result;
import com.jishaokang.cache.ResultCache;
import com.jishaokang.model.dto.Reply;

import com.jishaokang.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by NANA_Final on 2020/3/21.
 */
@RestController
@RequestMapping(value = "/api")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    //------------------------------------------------------------------
    @RequestMapping(value = "/user/reply/addReply",method = RequestMethod.POST)
    public Result addReply(@RequestBody Reply reply) {
        return replyService.addReply(reply);
    }

    @RequestMapping(value = "/all/reply/selectReplyByDiscussId",method = RequestMethod.POST)
    public Result selectReplyByDiscussId(@RequestBody Reply reply) {
        return replyService.selectReplyByDiscussId(reply);
    }

}