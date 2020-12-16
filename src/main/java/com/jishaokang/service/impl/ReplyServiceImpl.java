package com.jishaokang.service.impl;

import com.jishaokang.base.Result;
import com.jishaokang.cache.ResultCache;
import com.jishaokang.dao.DiscussDAO;
import com.jishaokang.dao.ReplyDAO;

import com.jishaokang.model.dto.Reply;

import com.jishaokang.service.ReplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by NANA_Final on 2020/3/21.
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDAO replyDAO;
    @Autowired
    private DiscussDAO discussDAO;

    @Override
    public Result addReply(Reply reply) {
        replyDAO.addReply(reply);
        discussDAO.incReplyTotal(reply.getDiscussId());
        return ResultCache.OK;
    }

    @Override
    public Result selectReplyByDiscussId(Reply reply) {
        List<Reply> replyInDB = replyDAO.selectReplyByDiscussId(reply);
        return ResultCache.getDataOk(replyInDB);
    }
}