package com.jishaokang.service;

import com.jishaokang.base.Result;

import com.jishaokang.model.dto.Reply;

/**
 * Created by NANA_Final on 2020/3/21.
 */
public interface ReplyService {

    Result addReply(Reply reply);

    Result selectReplyByDiscussId(Reply reply);
}
