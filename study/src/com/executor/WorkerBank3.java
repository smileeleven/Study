package com.executor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aiboleepro
 * @date 2018-01-10 下午3:00
 **/
public class WorkerBank3 extends Worker{

    @Override
    public Map<String,Object> call() throws Exception {
        Map<String,Object> map = new HashMap<>(2);
        try{
            throw new RuntimeException();
        }catch (Exception e){
            map.put("result",1);
            map.put("msg","银行3查询出错...");
            return map;
        }
    }
}
