package com.executor;

import com.soket.SoketUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author aiboleepro
 * @date 2018-01-10 下午2:59
 **/
public class WorkerBank1 extends Worker {

    @Override
    public Map<String,Object> call() throws Exception {
        Map<String,Object> map = new HashMap<>(2);
        TimeUnit.SECONDS.sleep(5);
        map.put("result",0);
        map.put("money",200);
        System.out.println("我是银行1： 你查询的资产为: 200");
        SoketUtil.request("测试");
        return map;
    }
}
