package com.jishaokang.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by NANA_Final on 2020/5/11.
 */
@Data
public class Code {

    public Code(String studentName, String submitCodeUrl) {
        this.studentName = studentName;
        this.submitCodeUrl = submitCodeUrl;
        this.fingerprints = new ArrayList<>();
    }
    private String studentName;
    private String code;
    private String submitCodeUrl;
    private String filterCode;
    private List<Integer> fingerprints;

    final String KEYWORDS = "False,None,True,and,as,assert,break,class,continue,def,del,elif,else,except,finally,for,from,global,if,import,in,is,lambda,nonlocal,not,or,pass,raise,return,try,while,with,yield";
    final String CHARACTERS = "qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM_1234567890";

    public void dealFilterCode(){
        String code = this.code;//预处理前的代码
        boolean proudKeyFlag = false;//是否在#后范围内的标志
        int quotesFlag = 0;//目前出现的引号个数，quotesFlag=3时表示在三个单引号内
        String word = "";//存储当前单词，以判断是否为保留字
        String filterCode = "";//预处理后的代码
        for (int i=0; i<code.length();i++){//逐字符处理
            char c = code.charAt(i);//当前处理的字符
            if ( CHARACTERS.contains(c+"") ){//判断是符号还是字母数字
                if (! proudKeyFlag || quotesFlag != 3) word = word + c;//当前符号为字母且不在注释内，则添加到当前单词中
            } else {
                if ( KEYWORDS.contains(word) ) {
                    filterCode = filterCode + word;//保留关键字
                }else{
                    filterCode = filterCode + "X";//替换自定义变量或方法名
                }
                word = "";//符号的出现标志着上个单词的结束
                if (c == '#') {//判断是否出现注释符号‘#’
                    proudKeyFlag = true;
                    continue;
                }
                if ( c == '\''){//判断是否出现注释符号引号
                    quotesFlag ++;
                    continue;
                }
                if (! proudKeyFlag && quotesFlag != 3 && c != '\n' && c != ' ') filterCode = filterCode + c;//保留符号
                if (proudKeyFlag && c == '\n') proudKeyFlag = false;//遇到换行结束#的注释范围
                if (quotesFlag == 3 && code.charAt(i-1) == '\'' && code.charAt(i-2) == '\'') quotesFlag = 0;//遇到三个引号结束引号的注释范围
                if (quotesFlag > 0 && quotesFlag != 3) quotesFlag = 0;//只有连续的引号能被计数
            }
        }
        this.filterCode =  filterCode;
    }

    final int BIGPRIME =  9973;//大质数，用于取模
    final int LUMPSIZE = 15;//块的长度，用于概括数据
    final int GROUPSIZE = 20;//组的大小，用于提取数据
    public void dealFingerprint() {
        String filterCode = this.filterCode;//获取过滤后的代码
        List<Integer> fingerprints = new ArrayList<>();//程序的指纹列表
        //分组进行提取块中最特殊的部分
        for (int group = 0;group < filterCode.length()/GROUPSIZE/LUMPSIZE; group++){
            int fingerprint = BIGPRIME+1;
            //用块来概括一小段代码
            for (int lump = 0;lump < GROUPSIZE;lump++){
                int sum = 0;
                int temp = 2;
                //概括方法为将块的每一位的字符编码数乘以 2的所在位置数的次方，再相加，取模大质数
                //获取包含了每一位的字符信息与位置信息的编码，即该块的概括
                for(int i =group*lump;i<group*(lump+1);i++){
                    sum = (sum + filterCode.charAt(i) * temp) % BIGPRIME;
                    temp = temp*2;
                }
                //获取每组中最小的块作为特征值
                if (sum < fingerprint) fingerprint = sum;
            }
            //添加指纹
            fingerprints.add(fingerprint);
        }
        this.fingerprints = fingerprints;
    }

}