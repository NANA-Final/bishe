package com.jishaokang.model.dto;

import lombok.Data;

/**
 * Created by NANA_Final on 2019/6/21.
 */
@Data
public class DataFile {

    private Integer competitionId;
    private Integer dataFileId;

    private String dataName;
    private String dataUrl;
    private String dataSize;
    private String dataIntroduction;

}