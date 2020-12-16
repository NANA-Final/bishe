package com.jishaokang.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Data
public class Discuss {
    private Integer discussId;
    private Integer userId;
    private Integer competitionId;

    private String discussTime;
    private String discussContent;
    private Integer discussType;
    private Integer replyTotal;

    private String userImage;
    private String username;

}