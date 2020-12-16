package com.jishaokang.model.dto;

import lombok.Data;

/**
 * Created by NANA_Final on 2020/3/21.
 */
@Data
public class User {
    private Integer userId;
    private String username;
    private String password;
    private String phone;
    private String userImage;

    private String studentName;
    private Integer classId;

    private String verification;

}