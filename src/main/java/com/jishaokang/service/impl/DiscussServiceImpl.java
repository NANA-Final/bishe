package com.jishaokang.service.impl;

import com.jishaokang.base.Result;
import com.jishaokang.cache.ResultCache;
import com.jishaokang.dao.DiscussDAO;

import com.jishaokang.model.dto.Discuss;

import com.jishaokang.service.DiscussService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Service
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    private DiscussDAO discussDAO;

    @Override
    public Result addDiscuss(Discuss discuss) {
        discussDAO.addDiscuss(discuss);
        return ResultCache.OK;
    }

    @Override
    public Result selectDiscussByCompetitionId(Discuss discuss) {
        List<Discuss> discusses = discussDAO.selectDiscussByCompetitionId(discuss);
        return ResultCache.getDataOk(discusses);
    }

    @Override
    public Result selectDiscussByUserId(Discuss discuss) {
        List<Discuss> discusses = discussDAO.selectDiscussByUserId(discuss);
        return ResultCache.getDataOk(discusses);
    }

    @Override
    public Result selectDiscussByKeyWord(Discuss discuss) {
        List<Discuss> discusses = discussDAO.selectDiscussByKeyWord(discuss);
        return ResultCache.getDataOk(discusses);
    }

    @Override
    public Result selectDiscuss(Discuss discuss) {
        List<Discuss> discusses = discussDAO.selectDiscuss(discuss);
        return ResultCache.getDataOk(discusses);
    }

    @Override
    public Result selectDiscussByDiscussId(Discuss discuss) {
        Discuss discussInDB = discussDAO.selectDiscussByDiscussId(discuss);
        return ResultCache.getDataOk(discussInDB);
    }
}