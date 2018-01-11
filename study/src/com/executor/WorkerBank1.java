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
        String param = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        param += "<params>" +
                    "<bankId>1</bankId>" +
                    "<userId>1</userId>" +
                "</params>";
        String res = SoketUtil.request(param);
        map.put("money",Integer.valueOf(res));
        System.out.println("我是银行1： 你查询的资产为: " + res);
        return map;
    }
}
