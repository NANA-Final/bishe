package com.jishaokang.dao;


import com.jishaokang.model.dto.Reply;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NANA_Final on 2020/3/21.
 */
@Repository
public interface ReplyDAO {


    void addReply(Reply reply);

    List<Reply>  selectReplyByDiscussId(Reply reply);


}