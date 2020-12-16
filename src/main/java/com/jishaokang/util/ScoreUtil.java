package com.jishaokang.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jishaokang.model.Code;
import com.jishaokang.model.Copy;
import com.jishaokang.model.dto.Score;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by NANA_Final on 2019/6/28.
 */
@Component
public class ScoreUtil {

    public String readFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        while ((str = br.readLine()) != null) {
            stringBuffer.append(str);
            stringBuffer.append("\n");
        }
        br.close();
        return stringBuffer.toString();
    }

    public double countScore(String submitUrl,String standardUrl) throws IOException {
        int correctNum = 0,allNum = 0;
        Gson gson = new Gson();
        Map<String,String> submitMap =  gson.fromJson(readFile(submitUrl),new TypeToken<Map<String, String>>() {}.getType());
        Map<String,String> standardMap = gson.fromJson(readFile(standardUrl),new TypeToken<Map<String, String>>() {}.getType());
        for (String key : standardMap.keySet()){
            String standardValue = standardMap.get(key);
            String submitValue = submitMap.get(key);
            if (standardValue.equals(submitValue)) correctNum++;
            allNum++;
        }
        double score = 1.0*correctNum/allNum;
        return score;
    }

    public List<Copy> checkCopy(List<Score> scores) throws IOException {
        List<Copy> copyLists = new LinkedList<>();
        List<Code> codes = new LinkedList<>();
        for (Score score : scores){
            Code code = new Code(score.getStudentName(),score.getSubmitCodeUrl());
            code.setCode(readFile(code.getCode()));
            code.dealFilterCode();
            code.dealFingerprint();
            codes.add(code);
        }
        for (int i = 0;i<codes.size()-1;i++){
            for(int j = i+1;j<codes.size();j++){
                List<Integer> minFingerPrints = codes.get(i).getFingerprints();
                List<Integer> maxFingerPrints = codes.get(j).getFingerprints();
                if (codes.get(i).getFingerprints().size()<codes.get(j).getFingerprints().size()) {
                    minFingerPrints = codes.get(j).getFingerprints();
                    maxFingerPrints = codes.get(i).getFingerprints();
                }
                int maxCopyItem = 0;
                for (int k = 0;k<maxFingerPrints.size()-minFingerPrints.size();k++){
                    int copyItem = 0;
                    for (int l = 0;l<minFingerPrints.size();l++){
                        if (minFingerPrints.get(l).equals(maxFingerPrints.get(l+k))) copyItem++;
                    }
                    if (copyItem > maxCopyItem) maxCopyItem = copyItem;
                }
                //代码相似度底线为90%
                if (maxCopyItem*100/minFingerPrints.size()>90){
                    //将当前比较的两份代码加入疑似抄袭列表
                    copyLists.add(new Copy(codes.get(i).getStudentName(),codes.get(j).getStudentName(),
                            codes.get(i).getSubmitCodeUrl(),codes.get(j).getSubmitCodeUrl(),
                            maxCopyItem*100/minFingerPrints.size()));
                }
            }
        }
        return copyLists;
    }
}