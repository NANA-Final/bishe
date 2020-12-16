package com.jishaokang.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Data
public class Competition {
    private Integer userId;

    private Integer competitionId;
    private Integer teacherId;
    private String teacherName;

    private String title;
    private String introduction;
    private String content;

    private String startTime;
    private String endTime;
    private String standardUrl;

    private Integer totalTeam;

    private Integer joinState;
    private Integer timeState;

    private Integer startNum;
    private Integer offset;
}