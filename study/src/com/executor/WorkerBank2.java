package com.executor;

import java.util.concurrent.TimeUnit;

/**
 * @author aiboleepro
 * @date 2018-01-10 下午3:00
 **/
public class WorkerBank2 extends Worker {

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        System.out.println("我是银行2： 你查询的资产为: 300");
        return 300;
    }
}
