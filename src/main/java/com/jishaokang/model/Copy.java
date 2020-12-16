package com.jishaokang.model;

import lombok.Data;

/**
 * Created by NANA_Final on 2020/5/11.
 */
@Data
public class Copy {

    public Copy() {
    }

    public Copy(String studentName1, String studentName2, String submitCodeUrl1,String submitCodeUrl2,int copyPoint) {
        this.studentName1 = studentName1;
        this.studentName2 = studentName2;
        this.submitCodeUrl1 = submitCodeUrl1;
        this.submitCodeUrl2 = submitCodeUrl2;
        this.copyPoint = copyPoint;
    }

    private String studentName1;
    private String studentName2;
    private String submitCodeUrl1;
    private String submitCodeUrl2;
    private int copyPoint;

}
