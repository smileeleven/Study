package com.executor;

/**
 * @author aiboleepro
 * @date 2018-01-10 下午3:00
 **/
public class WorkerBank3 extends Worker{

    @Override
    public Integer call() throws Exception {
        System.out.println("我是银行3： 你查询的资产为: 400");
        return 400;
    }
}
