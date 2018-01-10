package com.executor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author aiboleepro
 * @date 2018-01-10 下午3:00
 **/
public class WorkerBank2 extends Worker {

    @Override
    public Map<String,Object> call() throws Exception {
        Map<String,Object> map = new HashMap<>(2);
        TimeUnit.SECONDS.sleep(6);
        map.put("result",0);
        map.put("money",300);
        System.out.println("我是银行1： 你查询的资产为: 300");
        return map;
    }
}
