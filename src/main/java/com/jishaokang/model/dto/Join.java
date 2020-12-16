package com.jishaokang.model.dto;

import lombok.Data;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Data
public class Join {
    private Integer joinId;
    private Integer userId;
    private Integer classId;
    private Integer joinTime;
    private String studentName;

    private Integer teacherId;
    private String teacherName;

    private String className;
    private String classTime;

    private Integer totalStudent;


}