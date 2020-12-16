package com.jishaokang.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Data
public class Score {
    private Integer scoreId;

    private Integer userId;
    private Integer competitionId;

    private String submitTime;
    private String submitFileUrl;
    private String submitCodeUrl;

    private String studentName;

    private Double score;


}