package com.jishaokang.dao;


import com.jishaokang.model.dto.Discuss;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Repository
public interface DiscussDAO {


    void addDiscuss(Discuss discuss);

    List<Discuss> selectDiscussByCompetitionId(Discuss discuss);

    List<Discuss>  selectDiscussByUserId(Discuss discuss);

    List<Discuss> selectDiscussByKeyWord(Discuss discuss);

    List<Discuss>  selectDiscuss(Discuss discuss);

    Discuss selectDiscussByDiscussId(Discuss discuss);

    void incReplyTotal(Integer discussId);
}