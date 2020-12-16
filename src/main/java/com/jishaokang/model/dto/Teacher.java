package com.jishaokang.model.dto;

import lombok.Data;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Data
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private String password;
    private String phone;

    private String verification;
}
