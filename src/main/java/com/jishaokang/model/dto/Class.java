package com.jishaokang.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Data
public class Class {

    private Integer classId;

    private Integer teacherId;
    private String teacherName;

    private String className;
    private String classTime;

    private Integer totalStudent;


}