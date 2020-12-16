package com.jishaokang.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by NANA_Final on 2020/3/21.
 */
@Data
public class Reply {
    private Integer replyId;

    private Integer userId;
    private Integer discussId;

    private String replyTime;
    private String replyContent;

    private String userImage;
    private String username;


}