package com.jishaokang.cache;


import com.jishaokang.base.Result;

import java.util.HashMap;
import java.util.Map;

import static com.jishaokang.base.ResultStatusMessage.M_FAILURE;
import static com.jishaokang.base.ResultStatusMessage.M_OK;
import static com.jishaokang.base.ResultStatusValues.V_FAILURE;
import static com.jishaokang.base.ResultStatusValues.V_OK;

public class ResultCache {
    public static final Result OK = new Result(V_OK,M_OK);
    public static final Result FAILURE = new Result(V_FAILURE,M_FAILURE);

    public static Result getDataOk(Object object){
        Result result = new Result(V_OK,M_OK);
        result.setData(object);
        return result;
    }

    public static Result getListDataOk(int total,String itemName,Object object){
        Result result = new Result(V_OK,M_OK);
        HashMap map = new HashMap();
        map.put("total",total);
        map.put(itemName,object);
        result.setData(map);
        return result;
    }

    public static Result getDataError(Integer status,String message){
        Result result = new Result(status,message);
        return result;
    }
}