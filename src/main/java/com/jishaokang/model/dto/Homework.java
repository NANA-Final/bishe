package com.jishaokang.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Data
public class Homework {
    private Integer homeworkId;

    private Integer userId;
    private Integer competitionId;

    private Integer joinState;
    private Integer classId;

}