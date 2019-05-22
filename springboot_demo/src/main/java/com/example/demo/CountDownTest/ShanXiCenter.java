package com.example.demo.CountDownTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 描述: 山西调度中心
 * 作者: lishuai
 * 时间: 2019-05-19
 */
public class ShanXiCenter extends ControlCenter {

    public ShanXiCenter(CountDownLatch countdown){
        super(countdown,"山西省监控中心");

    }

    @Override
    public void check() throws Exception {
        System.out.println("山西监控中心开始检查.....");
        try {
            TimeUnit.SECONDS.sleep(1);
            int i = 1/0;
            System.out.println(i);
        } catch (Exception e) {
            throw e;
        }
        System.out.println("山西监控中心检查完毕，准备发车，一路顺风！！！！");
    }
}
