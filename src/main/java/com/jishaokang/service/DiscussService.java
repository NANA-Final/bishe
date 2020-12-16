package com.jishaokang.service;

import com.jishaokang.base.Result;

import com.jishaokang.model.dto.Discuss;

/**
 * Created by NANA_Final on 2019/6/21.
 */
public interface DiscussService {

    Result addDiscuss(Discuss discuss);

    Result selectDiscussByCompetitionId(Discuss discuss);

    Result selectDiscussByUserId(Discuss discuss);

    Result selectDiscussByKeyWord(Discuss discuss);

    Result selectDiscuss(Discuss discuss);

    Result selectDiscussByDiscussId(Discuss discuss);
}
