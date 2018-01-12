package com.executor;

import com.bean.BankParam;
import com.bean.BankResult;
import com.soket.SoketUtil;
import com.xml.JaxbUtil;

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
        BankParam bankParam = new BankParam();
        bankParam.setBankId("123");
        bankParam.setUserId("345");
        bankParam.setTradeNo("20180112");
        BankResult res = SoketUtil.request(bankParam);
        map.put("money",res.getMoney());
        System.out.println("我是银行1： 你查询的资产为: " + res);
        return map;
    }
}
