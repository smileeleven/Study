package com.executor;

import java.util.concurrent.TimeUnit;

/**
 * @author aiboleepro
 * @date 2018-01-10 下午2:59
 **/
public class WorkerBank1 extends Worker {

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        System.out.println("我是银行1： 你查询的资产为: 200");
        return 200;
    }
}
